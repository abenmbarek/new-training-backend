package org.exoplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exoplatform.entity.Client;
import org.json.JSONObject;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long     idArticle;

    private String   codeArticle;

    private String   designation;

    private Long     prixUnitaireHT;

    private Long     prixTVA;

    private Long     prixUnitaireTTC;

    private Client client;

 /*   @Override
    public String toString() {
        return "ArticleDto{" +
                "idArticle=" + idArticle +
                ", codeArticle='" + codeArticle + '\'' +
                ", designation='" + designation + '\'' +
                ", prixUnitaireHT=" + prixUnitaireHT +
                ", prixTVA=" + prixTVA +
                ", prixUnitaireTTC=" + prixUnitaireTTC +
                ", client=" + ClientMapper.clientToDto(client) +
                '}';
    }*/

    public JSONObject toJSONObject (long idClient){

          JSONObject jsonObject = new JSONObject();
                jsonObject.put("idArticle", idArticle);
                jsonObject.put("prixUnitaireHT", prixUnitaireHT);
                jsonObject.put("codeArticle", codeArticle);
                jsonObject.put("designation", designation);
                jsonObject.put("prixTVA", prixTVA);
                jsonObject.put("prixUnitaireTTC", prixUnitaireTTC);
                if(idClient != 0)
                jsonObject.put("client", idClient);
                else  jsonObject.put("client", ClientMapper.clientToDto(client).toJSONObject());
                //jsonArray.add(jsonObject);
        return jsonObject;
    }
}
