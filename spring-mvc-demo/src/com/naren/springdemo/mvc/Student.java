package com.naren.springdemo.mvc;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * @author narendra
 *
 */
public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String fevLang;
	private String[] operatingSystems;

	private LinkedHashMap<String, String> countryOption;

	public Student() {
		super();

		countryOption = new LinkedHashMap<String, String>();
		countryOption.put("INR", "India");
		countryOption.put("BRA", "Brazil");
		countryOption.put("USA", "United Nation");
		countryOption.put("GER", "Germany");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOption() {
		return countryOption;
	}

	public void setCountryOption(LinkedHashMap<String, String> countryOption) {
		this.countryOption = countryOption;
	}

	public String getFevLang() {
		return fevLang;
	}

	public void setFevLang(String fevLang) {
		this.fevLang = fevLang;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", fevLang="
				+ fevLang + ", operatingSystems=" + Arrays.toString(operatingSystems) + ", countryOption="
				+ countryOption + "]";
	}

}
