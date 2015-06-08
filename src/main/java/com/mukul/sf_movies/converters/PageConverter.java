package com.mukul.sf_movies.converters;

import java.util.ArrayList;
import java.util.List;

import com.mukul.sf_movies.helper.Page;

public class PageConverter<E,B> {

	public Page<E> convert(Page<B> beanPage, EntityConverter<E, B> converter) {
		Page<E> entityPage = new Page<E>();
		entityPage.setPageNumber(beanPage.getPageNumber());
		entityPage.setPagesAvailable(beanPage.getPagesAvailable());
		List<E> entities =  new ArrayList<E>();
		for(B bean : beanPage.getPageItems()){
			entities.add(converter.convert(bean));
		}
		entityPage.setPageItems(entities);
		return entityPage;
	}

	
	
}
