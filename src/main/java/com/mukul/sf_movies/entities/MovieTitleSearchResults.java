package com.mukul.sf_movies.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
public class MovieTitleSearchResults {
	
	private List<String> titles;
	public MovieTitleSearchResults() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	

}
