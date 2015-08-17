package com.myhb.hibernate.pojo;

public class Electrical extends Gear {
	
	private Float energy;
	
	public Electrical() {}

	public Float getEnergy() {
		return energy;
	}

	public void setEnergy(Float energy) {
		this.energy = energy;
	}
}
