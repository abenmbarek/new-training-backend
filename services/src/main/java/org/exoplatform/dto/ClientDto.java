package org.exoplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exoplatform.entity.Article;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientDto {


    private long clientId;

    private String prenom;

    private String name;

    private String adresse;

    private String email;

    private List<Article> Articles;

    public JSONObject toJSONObject (){

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id_client", clientId);
        jsonObject.put("adresse", adresse);
        jsonObject.put("email", email);
        jsonObject.put("name", name);
        jsonObject.put("prenom", prenom);
       if(Articles!=null){
            JSONArray jsonArray = new JSONArray();
            for (Article a : Articles){
                jsonArray.add(ArticleMapper.articleToDto(a).toJSONObject(a.getClient().getClientId()));
            }
            jsonObject.put("articles", jsonArray);
        }
        return jsonObject;
    }
}
