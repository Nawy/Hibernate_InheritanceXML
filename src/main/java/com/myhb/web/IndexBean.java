package com.myhb.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myhb.hibernate.HibernateUtil;
import com.myhb.hibernate.pojo.Eagly;
import com.myhb.hibernate.pojo.Electrical;
import com.myhb.hibernate.pojo.Engine;
import com.myhb.hibernate.pojo.MusicPlayer;
import com.myhb.hibernate.pojo.Television;
import com.myhb.hibernate.pojo.Wolf;

@ManagedBean(name="indexB")
@SessionScoped
public class IndexBean implements Serializable {
	/*
	 * 
	 */
	public static final long serialVersionUID = 1L;
	
	//Animals
	private String name;
	private Float flightAltitude = 0.0f;
	private Float runSpeed = 0.0f;
	
	//Devices
	private String vendor;
	private Float screenResolution = 0.0f;
	private Float volume = 0.0f;
	
	//Gears
	private String gearName;
	private Float energy = 0.0f;
	private Float fuel = 0.0f;
	
	@PostConstruct
	public void init()
	{
	}
	
	public void addAnimal()
	{
		//open session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try
		{
			trans = session.beginTransaction();
			
			if(flightAltitude > 0.0f)
			{
				Eagly eagly = new Eagly();
				eagly.setName(this.name);
				eagly.setFlightAltitude(this.flightAltitude);
				session.save(eagly);				
			}
			else if(runSpeed > 0.0f)
			{
				Wolf wolf = new Wolf();
				wolf.setName(this.name);
				wolf.setSpeedRun(this.runSpeed);
				session.save(wolf);		
			}
			//clear
			this.flightAltitude = 0.0f;
			this.runSpeed = 0.0f;
			
			trans.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.err);
		}
		finally
		{
			session.close();
		}
	}

	public void addDevice()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try
		{
			trans = session.beginTransaction();
			
			if(this.screenResolution > 0.0f)
			{
				Television tv = new Television();
				tv.setVendor(this.vendor);
				tv.setScreenResolution(this.screenResolution);
				session.save(tv);
			}
			else if(this.volume > 0.0f)
			{
				MusicPlayer mp = new MusicPlayer();
				mp.setVendor(this.vendor);
				mp.setVolume(this.volume);
				session.save(mp);
			}
			
			trans.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.err);
		}
		finally
		{
			session.close();
		}
	}
	
	public void addGear()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;
		try
		{
			trans = session.beginTransaction();
			
			if(this.energy > 0.0f)
			{
				Electrical el = new Electrical();
				el.setName(this.gearName);
				el.setEnergy(this.energy);
				session.save(el);
			}
			else if(this.fuel > 0.0f)
			{
				Engine en = new Engine();
				en.setName(this.gearName);
				en.setFuel(this.fuel);
				session.save(en);
			}
			
			trans.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.err);
		}
		finally
		{
			session.close();
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getFlightAltitude() {
		return flightAltitude;
	}

	public void setFlightAltitude(Float flightAltitude) {
		this.flightAltitude = flightAltitude;
	}

	public Float getRunSpeed() {
		return runSpeed;
	}

	public void setRunSpeed(Float runSpeed) {
		this.runSpeed = runSpeed;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Float getScreenResolution() {
		return screenResolution;
	}

	public void setScreenResolution(Float screenResolution) {
		this.screenResolution = screenResolution;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public String getGearName() {
		return gearName;
	}

	public void setGearName(String gearName) {
		this.gearName = gearName;
	}

	public Float getEnergy() {
		return energy;
	}

	public void setEnergy(Float energy) {
		this.energy = energy;
	}

	public Float getFuel() {
		return fuel;
	}

	public void setFuel(Float fuel) {
		this.fuel = fuel;
	}
}
