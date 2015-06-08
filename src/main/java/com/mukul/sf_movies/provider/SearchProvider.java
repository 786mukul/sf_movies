package com.mukul.sf_movies.provider;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.entities.MovieTitleSearchResults;
import com.mukul.sf_movies.manager.SearchManager;

public class SearchProvider {
  SearchManager searchManager;
  
  public MovieTitleSearchResults getMovieNames(String namePrefix, int limit) {
	 MovieTitleSearchResults movieTitleSearchResults = new MovieTitleSearchResults();
	  movieTitleSearchResults.setTitles(searchManager.SearchMovies(namePrefix, limit));
	  return movieTitleSearchResults;
  }

  @Required
public void setSearchManager(SearchManager searchManager) {
	this.searchManager = searchManager;
}
  
}
