package com.mukul.sf_movies;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Required;

import com.mukul.sf_movies.beans.SfMovieBean;
import com.mukul.sf_movies.dao.SfMovieBeanDao;
import com.mukul.sf_movies.dao.impl.SfMovieBeanDaoImpl;
import com.mukul.sf_movies.helper.Page;

@Path("/hello")
public class HelloWorldService {

	private SfMovieBeanDao sfMovieBeanDao;
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
		Page<SfMovieBean> page =  sfMovieBeanDao.getMovieBeans(1, 30);
		System.out.println(page.getPagesAvailable());
		List<SfMovieBean> sfMovieBeans = page.getPageItems();
		for(SfMovieBean sfb : sfMovieBeans){
		System.out.println(sfb);
		}
		return Response.status(200).entity(output).build();
 
	}

	@Required
	public void setSfMovieBeanDao(SfMovieBeanDao sfMovieBeanDao) {
		this.sfMovieBeanDao = sfMovieBeanDao;
	}
}
