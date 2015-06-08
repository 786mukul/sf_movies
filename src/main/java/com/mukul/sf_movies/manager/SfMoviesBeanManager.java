package com.mukul.sf_movies.manager;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.dao.SfMovieBeanDao;
import com.mukul.sf_movies.helper.Page;

public interface SfMoviesBeanManager {

	public Page<SfMovieBean> getSfMovieBeans(int pageNo, int pageSize);
	
	public Page<SfMovieBean> getSfMovieBeans(String title, int pageNo, int pageSize);
	
	public SfMovieBean getSfMovieBean(Long id);
	
}
