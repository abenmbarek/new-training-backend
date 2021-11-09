package org.exoplatform.services.rest;

import io.swagger.annotations.ApiParam;
import org.exoplatform.dto.ArticleMapper;
import org.exoplatform.dto.ClientDto;
import org.exoplatform.dto.ClientMapper;
import org.exoplatform.entity.Client;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.services.utils.ClientServiceInterface;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Column;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.JSONObject;

@Produces("application/json")
@Path("/client")
public class ClientRestService implements ResourceContainer {

    private static Log log =  ExoLogger.getLogger(ClientRestService.class);
    private final ClientServiceInterface clientServiceInterface;

    //ClientMapper clientMapper = new ClientMapper();

    public ClientRestService(ClientServiceInterface clientServiceInterface) {
        this.clientServiceInterface = clientServiceInterface;
    }

    @GET
    @Path("/listClients")
    //@RolesAllowed("users")
    public Response getClients() {
        List<Client> clients = clientServiceInterface.getClients() ;
        JSONArray jsonArray = new JSONArray();
        try {

            for (Client c : clients) {
                jsonArray.add(ClientMapper.clientToDto(c).toJSONObject());
                /*JSONObject jsonObject = new JSONObject();
                jsonObject.put("id_client", c.getClientId());
                jsonObject.put("adresse", c.getAdresse());
                jsonObject.put("email", c.getEmail());
                jsonObject.put("name", c.getName());
                jsonObject.put("prenom", c.getPrenom());
                jsonArray.add(jsonObject);*/
            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to get the client list").build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/addClient")
    //@RolesAllowed("users")
        public Response createClient(Client requestBody){
        JSONObject jsonObject = new JSONObject();
        try {
                Client c = clientServiceInterface.addClient(requestBody);

                jsonObject.put("id_client", c.getClientId());
                jsonObject.put("adresse", c.getAdresse());
                jsonObject.put("email", c.getEmail());
                jsonObject.put("name", c.getName());
                jsonObject.put("prenom", c.getPrenom());
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to create the client").build();
        }
        return Response.ok(jsonObject.toString(),MediaType.APPLICATION_JSON).build();


    }

    @POST
    @Path("/deleteClient/{id}")
    //@RolesAllowed("users")
    public Response deleteClient(@PathParam("id") String id){
        try {
          clientServiceInterface.deleteClient(Long.parseLong(id));
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to delete the client").build();
        }
        return Response.ok(MediaType.APPLICATION_JSON).build();


    }

    @POST
    @Path("/updateArticle/{id}")
    //@RolesAllowed("users")
    public Response updateArticle(@PathParam("id")String id,Client requestBody){
        JSONObject jsonObject = new JSONObject();
        try {
            Client c = clientServiceInterface.updateClient(Long.parseLong(id),requestBody);

            jsonObject.put("id_client", c.getClientId());
            jsonObject.put("adresse", c.getAdresse());
            jsonObject.put("email", c.getEmail());
            jsonObject.put("name", c.getName());
            jsonObject.put("prenom", c.getPrenom());
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to update the client").build();
        }
        return Response.ok(jsonObject.toString(),MediaType.APPLICATION_JSON).build();


    }

}
