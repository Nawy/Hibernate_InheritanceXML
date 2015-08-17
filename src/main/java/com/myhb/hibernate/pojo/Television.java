package com.myhb.hibernate.pojo;

public class Television extends Device {

	private Float screenResolution;

	public Television() {}
	
	public Float getScreenResolution() {
		return screenResolution;
	}

	public void setScreenResolution(Float screenResolution) {
		this.screenResolution = screenResolution;
	}
}
