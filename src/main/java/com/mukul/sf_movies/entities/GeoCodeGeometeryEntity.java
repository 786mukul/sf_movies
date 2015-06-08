package com.mukul.sf_movies.entities;

public class GeoCodeGeometeryEntity {

	 private GeoCodeBoundsEntity bounds;
	 private GeoCodeCoordinatesEntity location;
	 private String locationType;
	 private GeoCodeBoundsEntity viewPort;
	 public GeoCodeGeometeryEntity() {
		// TODO Auto-generated constructor stub
	}
	public GeoCodeBoundsEntity getBounds() {
		return bounds;
	}
	public void setBounds(GeoCodeBoundsEntity bounds) {
		this.bounds = bounds;
	}
	public GeoCodeCoordinatesEntity getLocation() {
		return location;
	}
	public void setLocation(GeoCodeCoordinatesEntity location) {
		this.location = location;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public GeoCodeBoundsEntity getViewPort() {
		return viewPort;
	}
	public void setViewPort(GeoCodeBoundsEntity viewPort) {
		this.viewPort = viewPort;
	}
	 
}
