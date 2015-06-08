package com.mukul.sf_movies.entities;

import java.util.List;

public class GeoCodedLocationEntity {

   private List<AddressComponentEntity> addressComponentEntities;
   private String formattedAddress;
   private GeoCodeGeometeryEntity geometry;
   private String place_id;
   private List<String> types;
   
   public GeoCodedLocationEntity() {
	// TODO Auto-generated constructor stub
}

public List<AddressComponentEntity> getAddressComponentEntities() {
	return addressComponentEntities;
}

public void setAddressComponentEntities(
		List<AddressComponentEntity> addressComponentEntities) {
	this.addressComponentEntities = addressComponentEntities;
}

public String getFormattedAddress() {
	return formattedAddress;
}

public void setFormattedAddress(String formattedAddress) {
	this.formattedAddress = formattedAddress;
}

public GeoCodeGeometeryEntity getGeometry() {
	return geometry;
}

public void setGeometry(GeoCodeGeometeryEntity geometry) {
	this.geometry = geometry;
}

public String getPlace_id() {
	return place_id;
}

public void setPlace_id(String place_id) {
	this.place_id = place_id;
}

public List<String> getTypes() {
	return types;
}

public void setTypes(List<String> types) {
	this.types = types;
}
 
   
}
