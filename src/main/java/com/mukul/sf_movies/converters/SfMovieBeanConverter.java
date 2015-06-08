package com.mukul.sf_movies.converters;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.google.maps.model.GeocodingResult;
import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.entities.GeoCodeCoordinatesEntity;
import com.mukul.sf_movies.entities.SfMovieEntity;
import com.mukul.sf_movies.manager.GeoCodingManager;

public class SfMovieBeanConverter implements EntityConverter<SfMovieEntity, SfMovieBean> {
	
	private GeoCodingManager geoCodingManager;

	public SfMovieEntity convert(SfMovieBean bean) {
		if(bean == null){
			return null;
		}
		SfMovieEntity sfMovieEntity = new SfMovieEntity();
		sfMovieEntity.setId(bean.getId());
		sfMovieEntity.setTitle(bean.getTitle());
		sfMovieEntity.setReleaseYear(bean.getReleaseYear());
		sfMovieEntity.setAddress(bean.getAddress());
		sfMovieEntity.setState(bean.getState());
		sfMovieEntity.setCity(bean.getCity());
		sfMovieEntity.setCountry(bean.getCountry());
		sfMovieEntity.setActor1(bean.getActor1());
		sfMovieEntity.setActor2(bean.getActor2());
		sfMovieEntity.setActor3(bean.getActor3());
		sfMovieEntity.setCity(bean.getCity());
		sfMovieEntity.setDirector(bean.getDirector());
		sfMovieEntity.setDistributor(bean.getDistributor());
		sfMovieEntity.setFunfacts(bean.getFunfacts());
		sfMovieEntity.setProduction(bean.getProduction());
		setGeoLocalizedLocationAttributes(sfMovieEntity);
		return sfMovieEntity;
	}

	private void setGeoLocalizedLocationAttributes(SfMovieEntity entity){
		List<GeocodingResult> geocodingResults = geoCodingManager.getGeocodedResults(entity.getAddress(), entity.getCity(), entity.getState());
		GeocodingResult bestResult = null;
		for(GeocodingResult geocodingResult : geocodingResults){
			if(!geocodingResult.partialMatch){
				bestResult = geocodingResult;
				break;
			}
		}
		if(bestResult == null && !geocodingResults.isEmpty()){
			bestResult = geocodingResults.get(0);
		}
		if(bestResult != null && bestResult.geometry!=null && bestResult.geometry.location !=null){
			GeoCodeCoordinatesEntity geoCodeCoordinatesEntity = new GeoCodeCoordinatesEntity();
			geoCodeCoordinatesEntity.setLatitude(bestResult.geometry.location.lat);
			geoCodeCoordinatesEntity.setLongitude(bestResult.geometry.location.lng);
			entity.setFormattedAddress(bestResult.formattedAddress);
			entity.setGeoCodeCoordinatesEntity(geoCodeCoordinatesEntity);
		}
	}
	
	@Required
	public void setGeoCodingManager(GeoCodingManager geoCodingManager) {
		this.geoCodingManager = geoCodingManager;
	}

	
}
