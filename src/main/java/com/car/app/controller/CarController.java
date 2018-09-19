package com.car.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.app.common.R;
import com.car.app.common.SystemConstant;
import com.car.app.common.request.IOTInfoRequest;
import com.car.app.common.request.IOTLocRequest;
import com.car.app.common.request.LoginRequest;
import com.car.app.common.request.RegisterRequest;
import com.car.app.common.request.ResetRequest;
import com.car.app.mapper.ImeiUserMapper;
import com.car.app.mapper.InfoMapper;
import com.car.app.mapper.UserMapper;
import com.car.app.model.ImeiUser;
import com.car.app.model.Information;
import com.car.app.model.User;
import com.car.app.service.Cache;
import com.car.app.utils.JwtUtils;
import com.car.app.utils.notification.NotificationUtil;



@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/funrockcar")
public class CarController {

	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
    private UserMapper userMapper;
	
	@Autowired
	private ImeiUserMapper iuMapper;
	
	@Autowired
	private InfoMapper infoMapper;
	
	@Autowired
	private Cache cache;
	
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST,consumes = "application/json")
	public R register(@RequestBody RegisterRequest request) {
		String account = request.getAccount();
		String password = request.getPassword();
		String imei = request.getImei();
		if(account == null || password == null) {
			return R.error().put("status", "5");
		}
		List<User> users = userMapper.getUserByAccount(account);
		if(users != null && users.size()>0) {
			return R.error().put("status", "2");
		}
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		if(request.getImei() != null) {
			ImeiUser imeiUser = new ImeiUser();
			imeiUser.setAccount(account);
			imeiUser.setImei(imei);
			imeiUser.setCount(1);
			List<ImeiUser> imeis = iuMapper.getIMEIUserByIMEIAndCount(imei, 1);
			if(imeis != null && imeis.size()>0) {
				return R.error().put("status", "3");
			}
			iuMapper.insertIMEIUser(imeiUser);
			user.setImei(imei);
		}
		userMapper.insertUser(user);
		
		return R.ok().put("status", "1");
	}
	
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST,consumes = "application/json")
	public R login(@RequestBody LoginRequest request) {
		if(request.getAccount() == null || request.getPassword() == null) {
			return R.error().put("status", "5");
		}
		List<User> users = userMapper.getUserByAccount(request.getAccount());
		Date exp = new Date();
		if(users != null && users.size()>0) {
			User u = users.get(0);
			if(u.getPassword().equals(request.getPassword())) {
				String deviceToken = request.getDeviceToken();
				if(deviceToken != null) {
					if (cache.get(request.getAccount()) == null || "".equals(cache.get(request.getAccount()))) {
						cache.save(request.getAccount(), deviceToken);
					}else {
						cache.update(request.getAccount(), deviceToken);
					}
				}
				//把token返回给客户端-->客户端保存至cookie-->客户端每次请求附带cookie参数
				String JWT = JwtUtils.createJWT("1", u.getAccount(), SystemConstant.JWT_TTL);
				List<String> imeis = new ArrayList<String>();
				imeis.add(u.getImei());
				try {	
					exp = JwtUtils.parseJWT(JWT).getExpiration();
				} catch (Exception e) {
					e.printStackTrace();
					return R.error().put("status", "4").put("msg", "JWT解析异常");
				}
				return R.ok().put("expirationDate", exp).put("status", "1").put("accessToken", JWT).put("userID", u.getId()).put("imeis", imeis);
			}else {
				return R.error().put("status", "3");
			}
		}else {
			return R.error().put("status", "2");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "resetpassword", method = RequestMethod.POST,consumes = "application/json")
	public R resetpassword(@RequestBody ResetRequest request) {
		String account = request.getAccount();
		String password = request.getPassword();
		if(account == null || password == null) {
			return R.error().put("status", "5");
		}
		List<User> users = userMapper.getUserByAccount(request.getAccount());
		if(users != null && users.size()>0) {
			userMapper.updatePassword(account, password);;
			return R.ok().put("status", "1");
			
		}else {
			return R.error().put("status", "2");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "iotinformation", method = RequestMethod.POST,consumes = "application/json")
	public R iotinformation(@RequestBody IOTInfoRequest request) {
		String imei = request.getImei();
		String sim = request.getSim();
		String collectTime = request.getTime();
		String longitude = request.getLongitude();
		String latitude = request.getLatitude();
		String iotstate = request.getIotstate();
		String utype = request.getType();
		if(imei == null || collectTime == null || longitude == null || latitude == null || iotstate == null) {
			return R.error().put("status", "5");
		}
		
		List<Information> infos = infoMapper.getAll();
		if(infos != null && infos.size()==100) {
			Information info = infos.get(0);
			infoMapper.deleteOne(info.getTimestamps(), info.getImei(), info.getIotstate());
		}
		List<Information> oldInfos = infoMapper.getInfosByImeiAndIotstateAndTime(iotstate, imei, collectTime);
		if(oldInfos != null && oldInfos.size() > 0) {
			R.error().put("status", "6").put("duplicate", true);
		}
		Information info = new Information();
		info.setTimestamps(new Date().getTime());
		info.setImei(imei);
		info.setIotstate(iotstate);
		info.setLatitude(latitude);
		info.setLongitude(longitude);
		info.setSim(sim);
		info.setuType(utype);
		info.setCollectTime(collectTime);
		infoMapper.insertInfo(info);
		Integer count = 0;
		List<ImeiUser> imus = iuMapper.getIMEIUserByIMEI(imei);
		if(imus != null) {
			ImeiUser imu = imus.get(0);
			count = imu.getCount();
		}
		if(count == 1) {
			iuMapper.updateImei(imei, 3);
		}else if(count == 2) {
			iuMapper.updateImei(imei, 0);
		}
		if("2".equals(iotstate)) {
			List<ImeiUser> imeiUsers = iuMapper.getIMEIUserByIMEI(imei);
			if(imeiUsers == null || imeiUsers.size()==0) {
				R.error().put("status", "4").put("msg", "未绑定imei与account，导致消息推送失败");
			}
			String deviceToken = cache.get(imeiUsers.get(0).getAccount());
			if(deviceToken != null && !"".equals(deviceToken)) {
				try {
					NotificationUtil.sendIOSUnicast(deviceToken);
				} catch (Exception e) {
					e.printStackTrace();
					R.error().put("status", "4").put("msg", "消息推送失败");
				}
			}
		}
		return R.ok().put("status", "1").put("binding", count);
	}
	
	@ResponseBody
	@RequestMapping(value = "iotlocations", method = RequestMethod.POST,consumes = "application/json")
	public R iotlocations(@RequestBody IOTLocRequest request) {
		String imei = request.getImei();
		String account = request.getAccount();
		String dataType = request.getDataType();
		String count = request.getCount();
//		String utype = request.getType();
		if(imei == null || account == null || dataType == null || count == null ) {
			return R.error().put("status", "5");
		}
		List<Information> infos = new ArrayList<Information>();
		if("3".endsWith(dataType)) {
			infos = infoMapper.getInfosByImei(imei);
		}else {
			infos = infoMapper.getInfosByImeiAndIotstate(dataType, imei);
		}
		if(infos == null || infos.size() == 0) {
			return R.notFound().put("status", "3");
		}
		if(!"0".endsWith(count)) {
			if(infos.size() < Integer.valueOf(count)) {
				count = String.valueOf(infos.size());
			}
			infos = infos.subList(0, Integer.valueOf(count));
		}
		return R.ok().put("status", "1").put("informations", infos);
	}
	
}
