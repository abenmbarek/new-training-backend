package org.exoplatform.stock.services.rest;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.stock.entity.Client;
import org.exoplatform.stock.services.utils.ClientService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("clients")
@Produces(MediaType.APPLICATION_JSON)
public class ClientRestService implements ResourceContainer {

    private static Log log = ExoLogger.getLogger(ClientRestService.class);

    @Inject
    ClientService clientService;

    @RolesAllowed("users")
    @GET
    @Path("/list")
    public Response getClient(){

        JSONArray jsonArray =new JSONArray();
        List<Client> clients= clientService.getAddClient();
        try {
            for(Client client : clients){
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("id_client", client.getClientId());
                jsonObject.put("first_name", client.getPrenom());
                jsonObject.put("last_name", client.getName());
                jsonObject.put("address_client", client.getAdresse());
                jsonObject.put("email_client", client.getEmail());
                jsonArray.add(jsonObject);
            }
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to get the client list").build();
        }

        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();

    }
}
