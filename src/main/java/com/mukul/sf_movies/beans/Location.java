package com.mukul.sf_movies.beans;

public class Location implements SfMoviesObject{
	public static final String TYPE="location";
	long id;
	String address;
	String city;
	String state;
	String country;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return this.id;
	}

	public String getTypeName() {
		return TYPE;
	}

	public int getType() {
		return TYPE.hashCode();
	}

}
