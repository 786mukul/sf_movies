package com.mukul.sf_movies.services;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.entities.MovieTitleSearchResults;
import com.mukul.sf_movies.provider.SearchProvider;

@Path("/search")
public class SearchService{
	
	private SearchProvider searchProvider;

	@GET
	@Path("/movies")
	@Produces("application/json")
	public Response getMovies(@QueryParam("title") String name, @QueryParam("limit") @DefaultValue("10") int limit){
		MovieTitleSearchResults movieTitleSearchResults =  searchProvider.getMovieNames(name, limit);
		return Response.ok(movieTitleSearchResults).build();
	}
	
	@Required
	public void setSearchProvider(SearchProvider searchProvider) {
		this.searchProvider = searchProvider;
	}
	
}
