package com.mukul.sf_movies.converters;

public interface EntityConverter<E,B> {
	public E convert(B bean);

}
