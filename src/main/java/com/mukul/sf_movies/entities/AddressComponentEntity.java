package com.mukul.sf_movies.entities;

import java.util.List;

public class AddressComponentEntity {
 private String shortName;
 private String longName;
 private List<String> types;
 
public AddressComponentEntity() {
}

public String getShortName() {
	return shortName;
}

public void setShortName(String shortName) {
	this.shortName = shortName;
}

public String getLongName() {
	return longName;
}

public void setLongName(String longName) {
	this.longName = longName;
}

public List<String> getTypes() {
	return types;
}

public void setTypes(List<String> types) {
	this.types = types;
}

 
}
