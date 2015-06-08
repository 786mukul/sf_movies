package com.mukul.sf_movies.manager.impl;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.dao.SfMovieBeanDao;
import com.mukul.sf_movies.helper.Page;
import com.mukul.sf_movies.manager.SfMoviesBeanManager;

public class SfMoviesBeanManagerImpl implements SfMoviesBeanManager{
	private SfMovieBeanDao sfMovieBeanDao;

	public Page<SfMovieBean> getSfMovieBeans(int pageNo, int pageSize) {
		return sfMovieBeanDao.getMovieBeans(pageNo, pageSize);
	}
	
	public Page<SfMovieBean> getSfMovieBeans(String title, int pageNo, int pageSize) {
		return sfMovieBeanDao.getMovieBeans(title, pageNo, pageSize);
	}
	
	public SfMovieBean getSfMovieBean(Long id) {
		return sfMovieBeanDao.getMovieBean(id);
	}


	@Required
	public void setSfMovieBeanDao(SfMovieBeanDao sfMovieBeanDao) {
		this.sfMovieBeanDao = sfMovieBeanDao;
	}
	
}
