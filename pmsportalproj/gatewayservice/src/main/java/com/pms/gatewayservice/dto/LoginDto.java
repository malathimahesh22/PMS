package com.pms.gatewayservice.dto;

import javax.validation.constraints.NotNull;

@lombok.Data
public class LoginDto {

	@NotNull(message = "UserName cannot be Empty")
	private String userName;

	@NotNull(message = "Password cannot be Empty")
	private String password;

	private Integer isRememberMe = 0;

}
