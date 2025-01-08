package com.bean;

public class DiseaseBean {
	String DNAME,DDATE,DSYMP,DMED,DLOC,DHEIR,image,HealthId;
	public DiseaseBean(){}
	public DiseaseBean(String dNAME, String dDATE, String dSYMP, String dMED,
			String dLOC, String dHEIR, String image,String HealthId) {
		super();
		DNAME = dNAME;
		DDATE = dDATE;
		DSYMP = dSYMP;
		DMED = dMED;
		DLOC = dLOC;
		DHEIR = dHEIR;
		this.image=image;
		this.HealthId=HealthId;
	}
	public String getDNAME() {
		return DNAME;
	}
	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}
	public String getDDATE() {
		return DDATE;
	}
	public void setDDATE(String dDATE) {
		DDATE = dDATE;
	}
	public String getDSYMP() {
		return DSYMP;
	}
	public void setDSYMP(String dSYMP) {
		DSYMP = dSYMP;
	}
	public String getDMED() {
		return DMED;
	}
	public void setDMED(String dMED) {
		DMED = dMED;
	}
	public String getDLOC() {
		return DLOC;
	}
	public void setDLOC(String dLOC) {
		DLOC = dLOC;
	}
	public String getDHEIR() {
		return DHEIR;
	}
	public void setDHEIR(String dHEIR) {
		DHEIR = dHEIR;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getHealthId() {
		return HealthId;
	}
	public void setHealthId(String HealthId) {
		this.HealthId = HealthId;
	}
	
}
