package org.exoplatform.services.rest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.exoplatform.services.utils.AddonServicesInterface;


import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.json.JSONArray;
import org.json.JSONObject;

import exo.platform.models.Client;

@Produces("application/json")
@Path("/demo")
public class AddonRestServices implements ResourceContainer {
	  private static Log log =  ExoLogger.getLogger(AddonRestServices.class);
	  private final AddonServicesInterface addonService;
	  
	  
	  
	  public AddonRestServices(AddonServicesInterface addonService) {
		this.addonService = addonService;
	}



	@GET
	  @Path("/listClients")
	  @RolesAllowed("users")
	  public Response getClients() {
	        try {
				
	        	return Response.ok(addonService.getAllClients()).build();
			} catch (Exception e) {
				// TODO: handle exception
				log.error(e.getMessage());
			    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity("An internal error has occurred when trying to get the client list").build();
			}
	        		
		     
	  }
	
}
