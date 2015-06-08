package com.mukul.sf_movies.manager.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.internal.RateLimitExecutorService;
import com.google.maps.model.GeocodingResult;
import com.mukul.sf_movies.manager.GeoCodingManager;

public class GoogleGeoCodingManagerImpl  implements GeoCodingManager{

	
	private GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyDzvzGljsk8Ze_p2Mn_S2w4HafTqoe-Z6I");
	
	public List<GeocodingResult> getGeocodedResults(String AddressString, String city,
			String state) {
		GeocodingResult[] results = null;
		if(AddressString!=null && city != null && state != null){
		StringBuilder sb = new StringBuilder(AddressString.length()+city.length()+state.length()+6);
		sb=sb.append(AddressString).append(", ").append(city).append(", ").append(state);
		try {
			results = GeocodingApi.geocode(context,
				    sb.toString()).await();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return results != null? Arrays.asList(results): new ArrayList<GeocodingResult>();
	}
	

}
