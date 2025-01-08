package com.bean;

public class CertificateBean 
{
	    String name,date,authority,image,HealthId;
		public CertificateBean(){}
		public CertificateBean(String name, String date, String authority, String image, String HealthId)
		{
			super();
			this.name = name;
			this.date = date;
			this.authority = authority;
			this.image = image;
			this.HealthId=HealthId;
		}
		
		public String getname() {
			return name;
		}
		
		public void setname(String name) {
			this.name = name;
		}
		
		public String getdate() {
			return date;
		}
		
		public void setdate(String date) {
			this.date = date;
		}
		
		public String getauthority() {
			return authority;
		}
		
		public void setauthority(String authority) {
			this.authority = authority;
		}
		
		public void setImage(String image) {
			this.image = image;
		}
		
		public String getImage() {
			return image;
		}
		
		
		public String getHealthId() {
			return HealthId;
		}
		
		public void setMemail(String HealthId) {
			this.HealthId = HealthId;
		}

		
}
