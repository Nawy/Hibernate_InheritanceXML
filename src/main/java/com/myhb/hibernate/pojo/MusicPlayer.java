package com.myhb.hibernate.pojo;

public class MusicPlayer extends Device {
	private Float volume;

	public MusicPlayer() {}
	
	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}
}
