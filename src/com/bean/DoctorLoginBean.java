package com.bean;

public class DoctorLoginBean {
	private String license,password;

	public DoctorLoginBean(String license, String password) {
		super();
		this.license = license;
		this.password = password;
	}

	public String getlicense() {
		return license;
	}

	public void setlicense(String license) {
		this.license = license;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
