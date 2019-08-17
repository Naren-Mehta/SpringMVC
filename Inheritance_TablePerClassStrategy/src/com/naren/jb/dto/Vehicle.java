package com.naren.jb.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "vehicle_name")
	private String vehicleName;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Vehicle( String vehicleName) {
		super();
		this.vehicleName = vehicleName;
	}

	public Vehicle() {
		super();
	}
	
	

	

}
