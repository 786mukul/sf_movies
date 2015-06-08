package com.mukul.sf_movies.manager;

import java.util.List;

import com.mukul.sf_movies.beans.SfMovieBean;

public interface SearchManager {
 public List<String> SearchMovies(String namePrefix, int limit);
}
