package org.exoplatform.services.rest;

import org.exoplatform.dto.ArticleDto;
import org.exoplatform.dto.ArticleMapper;
import org.exoplatform.dto.ClientDto;
import org.exoplatform.dto.ClientMapper;
import org.exoplatform.entity.Article;
import org.exoplatform.entity.Client;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.services.utils.ArticleServiceInterface;
import org.json.JSONObject;
import org.json.simple.JSONArray;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Produces("application/json")
@Path("/article")
public class ArticleRestServices implements ResourceContainer {
    private static Log log =  ExoLogger.getLogger(ArticleRestServices.class);

    private final ArticleServiceInterface articleServiceInterface ;

    public ArticleRestServices(ArticleServiceInterface articleServiceInterface){
        this.articleServiceInterface = articleServiceInterface;
    }

    @POST
    @Path("/addArticle/{id_client}")
    //@RolesAllowed("users")
    public Response createArticle( @PathParam("id_client") String id_client, Article requestBody){
        JSONObject jsonObject = new JSONObject();

        try {

            Article a = articleServiceInterface.addArticle(requestBody,Long.parseLong(id_client));

            jsonObject.put("id_article", a.getIdArticle());
            jsonObject.put("codeArticle", a.getCodeArticle());
            jsonObject.put("designation", a.getDesignation());
            jsonObject.put("prixUnitaireHT", a.getPrixUnitaireHT());
            jsonObject.put("prixTVA",a.getPrixTVA());
            jsonObject.put("prixUnitaireTTC",a.getPrixUnitaireTTC());
            jsonObject.put("client",a.getClient().getClientId());
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
        return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();


    }

    @GET
    @Path("/listArticles")
    //@RolesAllowed("users")
    public Response getArticles() {
        List<Article> articles = articleServiceInterface.getArticles() ;
        //List<JSONArray> articlesdto = new ArrayList<JSONArray>();
        JSONArray jsonArray = new JSONArray();
        try {

            for (Article a : articles) {
               // ClientDto clientDto =  ClientMapper.clientToDto(a.getClient());
                jsonArray.add(ArticleMapper.articleToDto(a).toJSONObject(0));

                /*JSONObject jsonObject = new JSONObject();
                jsonObject.put("id_article", a.getIdArticle());
                jsonObject.put("prixUnitaireHT", a.getPrixUnitaireHT());
                jsonObject.put("codeArticle", a.getCodeArticle());
                jsonObject.put("designation", a.getDesignation());
                jsonObject.put("prixTVA", a.getPrixTVA());
                jsonObject.put("prixUnitaireTTC", a.getPrixUnitaireTTC());
                jsonObject.put("client", clientDto);
                jsonArray.add(jsonObject);*/

            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to get the ARTICLE list").build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/deleteArticle/{id}")
    //@RolesAllowed("users")
    public Response deleteArticle(@PathParam("id") String id){
        try {
            articleServiceInterface.deleteArticle(Long.parseLong(id));
        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to delete the article").build();
        }
        return Response.ok(MediaType.APPLICATION_JSON).build();


    }

    @POST
    @Path("/updateArticle/{id}")
    //@RolesAllowed("users")
    public Response updateArticle(@PathParam("id")String id,Article requestBody){
        JSONObject jsonObject = new JSONObject();
        try {
            Article a = articleServiceInterface.updateArticle(Long.parseLong(id),requestBody);
            jsonObject = ArticleMapper.articleToDto(a).toJSONObject(0);

        } catch (Exception e) {
            // TODO: handle exception
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to update the client").build();
        }
        return Response.ok(jsonObject.toString(),MediaType.APPLICATION_JSON).build();


    }
}
