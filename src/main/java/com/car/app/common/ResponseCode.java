package com.car.app.common;

public enum ResponseCode {
	Success("200", "Success"),

	Unauthorized("401", "Account unauthorized, login first."),

	MissingParameter_$("400", "MissingParameter.%s \n The parameter - '%s'."),

	InvalidParameter_$("400", "InvalidParameter.%s \n The parameter - '%s'  is invalid."),

	InvalidParameter_$_InvalidChars("400", "InvalidParameter.InvalidChars \n The parameter - '%s' contains invalid chars."),

	InvalidParameter_$_Length("400", "InvalidParameter.Length \n The parameter - '%s'  beyond the length limit."),

	PermitError_$$("400", "PermitError.%s \n permit error, cause: %s"),

    CookieInvalid("402", "Cookie invalid."),

	Forbidden_$$("403", "Forbidden.%s \n"),

	NotExist_$$("404", "NotExist.%s \n %s"),

	AccountNotActive("406", "Account not active."),

	AlreadyExists_$$("409", "AlreadyExists.%s \n The [%s] does already exist."),

	InvalidVerificationCode("418", "Verification code invalid."),

	AuthServiceFailed("419", "3rd auth service failed."),

	SignFailed("420", "Checking signed data failed."),

	CertInvalid("421", "Checking certificate failed."),

	NoSuchRandom("422", "No such random."),

	SnAndUserNotMatch("423", "SN and user not match."),

	UserNameOrIdNotMatch("424", "User name or id not match."),

	ServerNotExist("425", "Server not exist."),

	CertNotExist("426", "Certification not exist."),

	InternalServerError_$$("500", "InternalServerError.%s \n %s."),

	DatabaseOperateError_$$("510", "DatabaseOperateError.%s \n %s."),

	;

	public final String code;

	public final String message;

	ResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
