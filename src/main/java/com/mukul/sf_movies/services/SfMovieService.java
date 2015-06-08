package com.mukul.sf_movies.services;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.entities.SfMovieEntity;
import com.mukul.sf_movies.helper.Page;
import com.mukul.sf_movies.provider.SfMoviesProvider;

@Path("/movie")
public class SfMovieService {
	private SfMoviesProvider SfMoviesBeanProvider;
	
	@GET
	@Path("/@all")
	@Produces("application/json")
	public Response getSfMovies(@QueryParam("title") String title,@QueryParam("page") @DefaultValue("1") int pageNo, @QueryParam("count") @DefaultValue("1") int pageSize){
		Page<SfMovieEntity> entities = SfMoviesBeanProvider.getSfMovieEntities(title,pageNo, pageSize);
		return Response.ok(entities).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getSfMovie(@PathParam("id") Long id) {
		SfMovieEntity sfMovieEntity = SfMoviesBeanProvider.getSfMovieEntity(id);
		if(sfMovieEntity == null){
			return Response.status(Status.NOT_FOUND).entity("No Resource available for id: "+id).build();
		}
		return Response.ok(sfMovieEntity).build();
	}
	
	
	@Required
	public void setSfMoviesBeanProvider(SfMoviesProvider sfMoviesBeanProvider) {
		SfMoviesBeanProvider = sfMoviesBeanProvider;
	}
	
	
	

}
