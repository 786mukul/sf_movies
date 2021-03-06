package com.mukul.sf_movies.beans;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SfMovieBean implements SfMoviesObject{
	public static final String TYPE = "sfMovieBean";
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
	String address;
	String city = "san francisco";
	String state = "california";
	String country = "United States";

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public String getTypeName() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return TYPE.hashCode();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object other){
		
		if(this == other){
			return true;
		}
		if (other instanceof SfMovieBean) {
			SfMovieBean anOtherSfMovieBean = (SfMovieBean) other;
			return new EqualsBuilder()
					.append(title,anOtherSfMovieBean.title)
					.append(releaseYear, anOtherSfMovieBean.releaseYear)
					.append(writer, anOtherSfMovieBean.writer)
					.append(address, anOtherSfMovieBean.address)
					.append(actor1, anOtherSfMovieBean.actor1)
					.append(actor2, anOtherSfMovieBean.actor2)
					.append(actor3, anOtherSfMovieBean.actor3)
					.append(funfacts, anOtherSfMovieBean.funfacts)
					.append(director, anOtherSfMovieBean.director)
					.append(distributor, anOtherSfMovieBean.distributor)
					.append(production, anOtherSfMovieBean.production)
					.append(state, anOtherSfMovieBean.state)
					.append(country, anOtherSfMovieBean.country).isEquals();
		}
		
		return false;
		
	}
	
	@Override
	public int hashCode(){
		return new HashCodeBuilder()
					.append(title)
					.append(releaseYear)
					.append(writer)
					.append(address)
					.append(actor1)
					.append(actor2)
					.append(actor3)
					.append(funfacts)
					.append(director)
					.append(distributor)
					.append(production)
					.append(state)
					.append(country).hashCode();
	}
	
	@Override
	public String toString(){
		return new StringBuilder()
		.append(title).append(" ")
		.append(releaseYear).append(" ")
		.append(writer).append(" ")
		.append(address).append(" ")
		.append(actor1).append(" ")
		.append(actor2).append(" ")
		.append(actor3).append(" ")
		.append(funfacts).append(" ")
		.append(director).append(" ")
		.append(distributor).append(" ")
		.append(production).append(" ")
		.append(state).append(" ")
		.append(country).toString();
	}
}
