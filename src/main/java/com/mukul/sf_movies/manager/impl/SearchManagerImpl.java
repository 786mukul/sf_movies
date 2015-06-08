package com.mukul.sf_movies.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.dao.SfMovieBeanDao;
import com.mukul.sf_movies.manager.SearchManager;

public class SearchManagerImpl implements SearchManager{

	SfMovieBeanDao sfMovieBeanDao;
	public List<String> SearchMovies(String namePrefix, int limit) {
		return sfMovieBeanDao.getMovieTitle(namePrefix, limit);
	}
	
	@Required
	public void setSfMovieBeanDao(SfMovieBeanDao sfMovieBeanDao) {
		this.sfMovieBeanDao = sfMovieBeanDao;
	}
	

}
