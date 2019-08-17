package com.naren.jb.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourVehicle extends Vehicle {

	private String wheelSteering;

	public String getWheelSteering() {
		return wheelSteering;
	}

	public void setWheelSteering(String wheelSteering) {
		this.wheelSteering = wheelSteering;
	}

	public FourVehicle( String wheelSteering) {
		this.wheelSteering = wheelSteering;
	}

	public FourVehicle() {
	}

}
