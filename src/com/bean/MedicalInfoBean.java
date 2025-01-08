package com.bean;

public class MedicalInfoBean {
	String bg,bp,height,weight,allergies,HealthId;
	public MedicalInfoBean(){}
	public MedicalInfoBean(String bg, String bp, String height, String weight,
			String allergies, String HealthId) {
		super();
		this.bg = bg;
		this.bp = bp;
		this.height = height;
		this.weight = weight;
		this.allergies = allergies;
		this.HealthId = HealthId;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getHealthId() {
		return HealthId;
	}
	public void setHealthId(String HealthId) {
		this.HealthId = HealthId;
	}
	
	
	
}
