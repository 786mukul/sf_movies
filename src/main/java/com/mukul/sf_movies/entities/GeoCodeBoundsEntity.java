package com.mukul.sf_movies.entities;

public class GeoCodeBoundsEntity {
 private GeoCodeCoordinatesEntity nortEastCoordinates;
 private GeoCodeCoordinatesEntity southWestCoordinates;
 
 GeoCodeBoundsEntity(){
	 
 }

public GeoCodeCoordinatesEntity getNortEastCoordinates() {
	return nortEastCoordinates;
}

public void setNortEastCoordinates(GeoCodeCoordinatesEntity nortEastCoordinates) {
	this.nortEastCoordinates = nortEastCoordinates;
}

public GeoCodeCoordinatesEntity getSouthWestCoordinates() {
	return southWestCoordinates;
}

public void setSouthWestCoordinates(
		GeoCodeCoordinatesEntity southWestCoordinates) {
	this.southWestCoordinates = southWestCoordinates;
}
 
 
}
