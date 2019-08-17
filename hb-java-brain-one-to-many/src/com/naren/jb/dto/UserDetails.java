package com.naren.jb.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class UserDetails {

	@Id
	@GeneratedValue
	private int id;

	private String userName;

	@ElementCollection
	private Set<Address> listOfAddress = new HashSet<Address>();

//
//	@Embedded
//	@AttributeOverrides(
//			{ @AttributeOverride(name = "street", column = @Column(name = "Home_street_name")) ,
//			 @AttributeOverride(name = "city", column = @Column(name = "Home_city_name")),
//			@AttributeOverride(name = "state", column = @Column(name = "Home_state_name")),
//			@AttributeOverride(name = "country", column = @Column(name = "Home_country_name"))
//			})
//	Address homeAddress;
//
//	@Embedded
//	Address officeAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

}
