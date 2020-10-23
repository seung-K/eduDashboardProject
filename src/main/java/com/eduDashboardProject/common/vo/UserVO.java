package com.eduDashboardProject.common.vo;

import lombok.Data;

@Data
public class UserVO {

	private String identification;
	private String password;
	
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
