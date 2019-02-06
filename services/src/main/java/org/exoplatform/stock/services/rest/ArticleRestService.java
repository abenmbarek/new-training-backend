package org.exoplatform.stock.services.rest;

import java.util.List;

import org.exoplatform.services.rest.resource.ResourceContainer;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.stock.entity.Article;
import org.exoplatform.stock.services.utils.ArticleService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@Path("articles")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleRestService implements ResourceContainer{

    private static Log   log = ExoLogger.getLogger(ArticleRestService.class);

    @Inject
    private ArticleService articleService;

    @RolesAllowed("users")
    @GET
    @Path("/list")
    public Response getArticle(){
        List<Article> articles = articleService.getAllArticle();
        JSONArray jsonArray = new JSONArray();
        try {
            for (Article article : articles) {
              JSONObject jsonObject = new JSONObject();
              jsonObject.put("id_article", article.getIdArticle());
              jsonObject.put("designation_article", article.getDesignation());
              jsonObject.put("code_article", article.getCodeArticle ());
              jsonObject.put("prix_tva_article", article.getPrixTVA());
              jsonObject.put("prix_uni_article", article.getPrixUnitaireHT());
              jsonObject.put("categorie_article", article.getCategory().getIdCategorye());
              jsonArray.add(jsonObject);
            }
        }
        catch (Exception e){
           log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred When trying to import articles list")
                    .build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();

    }
}
