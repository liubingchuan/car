package com.car.app.utils;

public enum ErrorCode {
	API_ADAPTER_DATA_NULL("ASO-API-ADAPTER-3-NULL","3","访问没有返回有效数据！",""),
	API_ADAPTER_GOOD("ASO-API-ADAPTER-4-GOOD", "4", "用户访问成功！", ""),
	API_ADAPTER_SERVER_ERROR("ASO-API-ADAPTER-1-SERVER_ERROR", "1", "api-adapter访问嫦娥服务出现内部错误，请检查服务", ""),
	API_ADAPTER_COOKIE_INVALID("ASO-API-ADAPTER-2-COOKIE_INVALID", "2", "登录Cookie异常或失效，请重新登录", ""),
    API_ADAPTER_INVALID_URI("ASO-API-ADAPTER-1-INVALID_URI", "1", "您访问的服务或地址不存在", ""),
	API_ADAPTER_NOT_LOGGED("ASO-API-ADAPTER-1-NOT_LOGGED", "1", "用户未登录或登录状态失效，请重新登录", ""),
    API_ADAPTER_NOT_PERMITTED("ASO-API-ADAPTER-1-NOT_PERMITTED", "1", "您没有权限执行此操作", ""),
    API_ADAPTER_INTERNAL_SERVER_ERROR("ASO-API-ADAPTER-1-INTERNAL_SERVER_ERROR", "1", "服务出现内部错误，请检查服务", ""),
    API_ADAPTER_ACCOUNT_NOT_EXIST("ASO-API-ADAPTER-1-ACCOUNT_NOT_EXIST", "1", "该云账户不存在，请检查", ""),
    API_ADAPTER_CHECK_PERMISSION_EXCEPTION("ASO-API-ADAPTER-1-CHECK_PERMISSION_EXCEPTION", "1", "鉴权服务访问异常，请检查服务", ""),
    API_ADAPTER_GET_DEPARTMENT_FAILED("ASO-API-ADAPTER-2-GET_DEPARTMENT_FAILED", "2", "获取用户部门失败，请检查服务", ""),
    API_ADAPTER_USERNAME_NULL("ASO-API-ADAPTER-1-USERNAME_NULL", "1", "用户名为空，请重新输入", ""),
    API_ADAPTER_PASSWORD_NULL("ASO-API-ADAPTER-1-PASSWORD_NULL", "1", "密码为空，请重新输入", ""),
    API_ADAPTER_ALIYUN_LANG_NULL("ASO-API-ADAPTER-1-ALIYUN_LANG_NULL", "1", "传入值本地语言为空，请检查服务", ""),
    API_ADAPTER_ALIYUN_COUNTRY_NULL("ASO-API-ADAPTER-1-ALIYUN_COUNTRY_NULL", "1", "传入值国家为空，请检查服务", ""),
    API_ADAPTER_ACCOUNT_NOT_ACTIVE("ASO-API-ADAPTER-2-ACCOUNT_NOT_ACTIVE", "2", "当前用户已被回收，无法登陆", ""),
    API_ADAPTER_CHECK_ACCOUNT_ACTIVE_FAILED("ASO-API-ADAPTER-1-CHECK_ACCOUNT_ACTIVE_FAILED", "1", "检查用户是否被回收失败，请检查服务", ""),
    API_ADAPTER_GOOGLE_AUTH_CODE_INVALID("ASO-API-ADAPTER-1-GOOGLE_AUTH_CODE_INVALID", "1", "验证码错误，请重新输入", ""),
    API_ADAPTER_USBKEY_SERVERS_NOT_EXISTED("ASO-API-ADAPTER-1-USBKEY_SERVERS_NOT_EXISTED", "1", "该用户开启了USBKey认证，但该认证服务没有添加认证服务器，认证失败，请使用安全管理员添加", ""),
    API_ADAPTER_USBKEY_RANDOM_NOT_EXISTED("ASO-API-ADAPTER-1-USBKEY_RANDOM_NOT_EXISTED", "1", "该用户开启了USBKey认证，登录签名中携带的随机码已失效，请清理缓存后重新登录", ""),
    API_ADAPTER_USBKEY_SN_NOT_MATCH("ASO-API-ADAPTER-1-USBKEY_SN_NOT_MATCH", "1", "该用户开启了USBKey认证，USBKey的SN号未与账号绑定，请使用安全管理员重新绑定", ""),
    API_ADAPTER_USBKEY_TAAS_SIGN_INVALID("ASO-API-ADAPTER-1-USBKEY_TAAS_SIGN_INVALID", "1", "该用户开启了USBKey认证，调用第三方厂商接口校验签名返回失败，请检查服务", ""),
    API_ADAPTER_USBKEY_TAAS_CERT_INVALID("ASO-API-ADAPTER-1-USBKEY_TAAS_CERT_INVALID", "1", "该用户开启了USBKey认证，调用第三方厂商接口校验证书返回失败，请检查服务", ""),
    API_ADAPTER_USBKEY_TAAS_GET_RANDOM_FAILED("ASO-API-ADAPTER-1-USBKEY_TAAS_GET_RANDOM_FAILED", "1", "该用户开启了USBKey认证，调用第三方厂商接口获取验证码失败，请检查服务", ""),
    API_ADAPTER_PKI_SERVERS_NOT_EXISTED("ASO-API-ADAPTER-1-PKI_SERVERS_NOT_EXISTED", "1", "该用户开启了PKI认证，但该认证服务没有添加认证服务器，认证失败，请使用安全管理员添加", ""),
    API_ADAPTER_PKI_CERT_NOT_EXISTED("ASO-API-ADAPTER-1-PKI_CERT_NOT_EXISTED", "1", "该用户开启了PKI认证，但未从请求中获取到客户端证书，请检查服务", ""),
    API_ADAPTER_PKI_PARSE_CERT_FAILED("ASO-API-ADAPTER-1-PKI_PARSE_CERT_FAILED", "1", "该用户开启了PKI认证，解析客户端证书失败，请检查证书", ""),
    API_ADAPTER_PKI_CERT_NEED_NAME_OR_ID("ASO-API-ADAPTER-1-PKI_CERT_NEED_NAME_OR_ID", "1", "该用户开启了PKI认证，客户端证书中缺少用户名或身份证信息，请检查证书", ""),
    API_ADAPTER_PKI_SERVERS_INVALID("ASO-API-ADAPTER-1-PKI_SERVERS_INVALID", "1", "该用户开启了PKI认证，该认证服务的认证服务器配置参数异常，请检查", ""),
    API_ADAPTER_PKI_SERVERS_CONNECT_FAILED("ASO-API-ADAPTER-1-PKI_SERVERS_CONNECT_FAILED", "1", "该用户开启了PKI认证，该认证服务的认证服务器连接异常，请检查", ""),
    API_ADAPTER_PKI_SERVICE_EXCEPTION("ASO-API-ADAPTER-1-PKI_SERVICE_EXCEPTION", "1", "该用户开启了PKI认证，该认证服务的认证服务返回异常，请检查服务", ""),
    API_ADAPTER_PKI_NAME_OR_ID_NOT_MATCHED("ASO-API-ADAPTER-1-PKI_NAME_OR_ID_NOT_MATCHED", "1", "该用户开启了PKI认证，客户端证书中的用户名或身份证信息与该账户绑定的不一致，请检查配置", ""),
    API_ADAPTER_NO_SUCH_AUTH_SERVICE("ASO-API-ADAPTER-1-NO_SUCH_AUTH_SERVICE", "1", "选择的认证服务不存在，请使用安全管理员重新选择", ""),
    API_ADAPTER_LOGIN_POLICY_FORBIDDEN("ASO-API-ADAPTER-1-LOGIN_POLICY_FORBIDDEN", "1", "由于登录策略的限制，该用户或IP当前被禁止访问", ""),
    API_ADAPTER_CHECK_LOGIN_POLICY_EXCEPTION("ASO-API-ADAPTER-1-CHECK_LOGIN_POLICY_EXCEPTION", "1", "登录策略服务访问异常，请检查服务", ""),
    API_ADAPTER_LOGIN_NAME_OR_PW_INVALID("ASO-API-ADAPTER-1-LOGIN_NAME_OR_PW_INVALID", "1", "用户名或密码错误，登录失败", ""),
    API_ADAPTER_NO_ALIUID_IN_TICKET("ASO-API-ADAPTER-1-NO_ALIUID_IN_TICKET", "1", "从登录的Cookie中无法获取到云账号ID，请检查服务", ""),
    API_ADAPTER_GET_LAST_LOGIN_TIME_FAILED("ASO-API-ADAPTER-2-GET_LAST_LOGIN_TIME_FAILED", "2", "获取上次登录时间失败，请检查服务", ""),
  

    WHITELIST_SERVICE_EXISTED("ASO-WHITELIST-2-SERVICE_EXISTED", "2", "该服务在白名单中已存在", ""),
    WHITELIST_EMPTY_PRODUCT("ASO-WHITELIST-1-EMPTY_PRODUCT", "1", "传入参数产品的值为空，请检查", ""),
    WHITELIST_EMPTY_SERVICE("ASO-WHITELIST-1-EMPTY_SERVICE", "1", "传入参数服务的值为空，请检查", ""),

    TFA_INVALID_SOLUTION("ASO-2FA-1-INVALID_SOLUTION", "1", "选择的认证方案不合法，请检查", ""),
    TFA_INVALID_IP("ASO-2FA-1-INVALID_IP", "1", "IP地址不合法，请重新输入", ""),
    TFA_INVALID_PORT("ASO-2FA-1-INVALID_PORT", "1", "Port值不合法，请重新输入", ""),
    TFA_PORT_IS_NULL("ASO-2FA-1-PORT_IS_NULL", "1", "PKI认证的认证服务器Port不能为空，请重新输入", ""),
    TFA_IP_EXISTED("ASO-2FA-1-IP_EXISTED", "1", "该IP已绑定，不可重复绑定", ""),
    TFA_SERVER_NOT_EXIST("ASO-2FA-1-SERVER_NOT_EXIST", "1", "该认证服务器记录不存在，无法操作", ""),
    TFA_TAAS_SERVICE_UNAVALIABLE("ASO-2FA-2-TAAS_SERVICE_UNAVALIABLE", "2", "该认证服务器服务不可用，请检查", ""),
    TFA_PKI_SERVER_PING_FAILED("ASO-2FA-2-PKI_SERVER_PING_FAILED", "2", "无法Ping通该服务器，请检查", ""),
    TFA_SN_EXISTED("ASO-2FA-1-SN_EXISTED", "1", "该SN号已绑定，不可重复绑定", ""),
    TFA_CONFIG_SERVER_FIRST("ASO-2FA-3-CONFIG_SERVER_FIRST", "3", "请先配置认证服务器，再开启认证", ""),
    TFA_CONFIG_SN_FIRST("ASO-2FA-3-CONFIG_SN_FIRST", "3", "请先为账号绑定SN号，再开启认证", ""),
    TFA_NAME_IS_NULL("ASO-2FA-1-NAME_IS_NULL", "1", "用户姓名不能为空", ""),
    TFA_ID_IS_NULL("ASO-2FA-1-ID_IS_NULL", "1", "用户身份证号不能为空", ""),
    TFA_ID_INVALID("ASO-2FA-1-ID_INVALID", "1", "用户身份证号长度不合法，需要为15或18位", ""),
    TFA_ID_EXISTED("ASO-2FA-1-ID_EXISTED", "1", "用户身份证号已绑定，不可重复绑定", ""),
    TFA_ID_OR_NAME_IS_NULL("ASO-2FA-1-ID_OR_NAME_IS_NULL", "1", "用户姓名或身份证号为空，请先配置好后再开启认证", ""),
    TFA_SN_IS_NULL("ASO-2FA-1-SN_IS_NULL", "1", "传入参数SN号的值为空，请检查", "");

    public final String key;

    public final String level;

    public final String cn;

    public final String en;

    ErrorCode(String key, String level, String cn, String en) {
        this.key = key;
        this.level = level;
        this.cn = cn;
        this.en = en;
    }
   

}
