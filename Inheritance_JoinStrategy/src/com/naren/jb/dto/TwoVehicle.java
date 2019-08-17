package com.naren.jb.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoVehicle extends Vehicle {

	private String wheelHandle;

	public String getWheelHandle() {
		return wheelHandle;
	}

	public void setWheelHandle(String wheelHandle) {
		this.wheelHandle = wheelHandle;
	}

	public TwoVehicle(String wheelHandle) {
		this.wheelHandle = wheelHandle;
	}

	public TwoVehicle() {
	}

}
