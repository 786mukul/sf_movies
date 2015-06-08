package com.mukul.sf_movies.beans;

import java.io.Serializable;

public class Movie implements SfMoviesObject, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1693365407347476416L;
	public static final String TYPE = "movie";
	Long id;
	String title;
	String releaseYear;
	String funfacts;
	String production;
	String distributor;
	String director;
	String writer;
	String actor1;
	String actor2;
	String actor3;
	
   public Movie() {
	// TODO Auto-generated constructor stub
}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getFunfacts() {
		return funfacts;
	}

	public void setFunfacts(String funfacts) {
		this.funfacts = funfacts;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActor1() {
		return actor1;
	}

	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public String getActor2() {
		return actor2;
	}

	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public String getActor3() {
		return actor3;
	}

	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public String getTypeName() {
		return TYPE;
	}

	public int getType() {
		
		return TYPE.hashCode();
	}


}
