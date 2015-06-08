package com.mukul.sf_movies.dao;

import java.util.List;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.helper.Page;

public interface SfMovieBeanDao {
	
	public Page<SfMovieBean> getMovieBeans(final int pageNo, final int pageSize);
	
	public SfMovieBean getMovieBean(Long id);
	 
	public List<String> getMovieTitle(String namePrefix, int limit);
	
	public Page<SfMovieBean> getMovieBeans(final String title, final int pageNo, final int pageSize);

}
