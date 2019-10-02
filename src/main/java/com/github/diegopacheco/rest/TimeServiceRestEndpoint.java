package com.github.diegopacheco.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class TimeServiceRestEndpoint extends Application {
		
  @GET
  @Path("/health")
  @Produces(MediaType.APPLICATION_JSON)
  public Response health() {
      return Response.ok().type(MediaType.APPLICATION_JSON).entity("{\"status\": \"200\"}").build();
  }
	
  @GET
  @Path("/datetime")
  @Produces(MediaType.APPLICATION_JSON)
  public String getDate() {
      return new Date().toString();
  }
	
}