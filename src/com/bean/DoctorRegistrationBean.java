package com.bean;

public class DoctorRegistrationBean {
	
	String license,password,image;
	public DoctorRegistrationBean(){}
	public DoctorRegistrationBean(String license, String password, String image) {
		super();
		this.license = license;
		this.password = password;
		this.image = image;
	}
	public String getlicense() {
		return license;
	}
	public void setlicense(String license) {
		this.license = license;
	}
	public String getpassword() {
		return password;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
