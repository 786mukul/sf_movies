package com.mukul.sf_movies.manager;

import java.util.List;

import com.google.maps.model.GeocodingResult;

public interface GeoCodingManager {
	
	public List<GeocodingResult> getGeocodedResults(String AddressString, String city, String state);

}
