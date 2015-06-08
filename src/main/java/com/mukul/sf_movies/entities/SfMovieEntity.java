package com.mukul.sf_movies.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@XmlRootElement
public class SfMovieEntity implements Serializable{
	
	Long id;
	String title;
	String releaseYear;
	String funfacts;
	String production;
	String distributor;
	String director;
	String writer;
	String actor1;
	String actor2;
	String actor3;
	String address;
	String city ;
	String state;
	String country;
    GeoCodeCoordinatesEntity geoCodeCoordinatesEntity;
    String formattedAddress;
    
   
	
	public SfMovieEntity() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getFunfacts() {
		return funfacts;
	}
	public void setFunfacts(String funfacts) {
		this.funfacts = funfacts;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActor1() {
		return actor1;
	}
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}
	public String getActor2() {
		return actor2;
	}
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	public String getActor3() {
		return actor3;
	}
	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}
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
	public GeoCodeCoordinatesEntity getGeoCodeCoordinatesEntity() {
		return geoCodeCoordinatesEntity;
	}
	public void setGeoCodeCoordinatesEntity(
			GeoCodeCoordinatesEntity geoCodeCoordinatesEntity) {
		this.geoCodeCoordinatesEntity = geoCodeCoordinatesEntity;
	}
	public String getFormattedAddress() {
		return formattedAddress;
	}
	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}
	
}
