package org.exoplatform.stock.services.rest;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.stock.entity.Category;
import org.exoplatform.stock.services.utils.CategoryService;

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


@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryRestService implements ResourceContainer {

    private static Log log = ExoLogger.getLogger(CategoryRestService.class);

    @Inject
    CategoryService categoryService;

    @RolesAllowed("users")
    @GET
    @Path("/list")
    public Response getCategory(){

        List<Category> categories =categoryService.getAllCategories();
        JSONArray jsonArray =new JSONArray();
        try {
            for(Category category : categories){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id_category", category.getIdCategorye());
                jsonObject.put("code_category" , category.getCodeCategorie());
                jsonObject.put("name_category" , category.getLibelle());
                jsonArray.add(jsonObject);

            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred When trying to import categories list")
                    .build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }
}
