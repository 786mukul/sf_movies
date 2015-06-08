package com.mukul.sf_movies.provider;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.converters.PageConverter;
import com.mukul.sf_movies.converters.SfMovieBeanConverter;
import com.mukul.sf_movies.entities.SfMovieEntity;
import com.mukul.sf_movies.helper.Page;
import com.mukul.sf_movies.manager.SfMoviesBeanManager;

public class SfMoviesProvider {
	SfMoviesBeanManager sfMoviesBeanManager;
	PageConverter<SfMovieEntity, SfMovieBean> pageConverter;
	SfMovieBeanConverter sfMovieBeanConverter;
	 
	 public Page<SfMovieEntity> getSfMovieEntities(String title, int pageNo, int pageSize) {
			Page<SfMovieBean> page = sfMoviesBeanManager.getSfMovieBeans(title,pageNo, pageSize);
			return pageConverter.convert(page, sfMovieBeanConverter);
			
		 }
	 
	 public SfMovieEntity getSfMovieEntity(long id){
		 return sfMovieBeanConverter.convert(sfMoviesBeanManager.getSfMovieBean(id));
	 }
	 
	 @Required
	public void setSfMoviesBeanManager(SfMoviesBeanManager sfMoviesBeanManager) {
		this.sfMoviesBeanManager = sfMoviesBeanManager;
	}

	 @Required
	public void setPageConverter(
			PageConverter<SfMovieEntity, SfMovieBean> pageConverter) {
		this.pageConverter = pageConverter;
	}

	 @Required
	public void setSfMovieBeanConverter(SfMovieBeanConverter sfMovieBeanConverter) {
		this.sfMovieBeanConverter = sfMovieBeanConverter;
	}
	
}
