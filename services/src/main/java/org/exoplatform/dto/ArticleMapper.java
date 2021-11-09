package org.exoplatform.dto;

import org.exoplatform.entity.Article;

public class ArticleMapper {

    public static ArticleDto articleToDto(Article entity){
        ArticleDto res = new ArticleDto();

        if(entity != null){
            res.setIdArticle(entity.getIdArticle());
            res.setCodeArticle(entity.getCodeArticle());
            res.setClient(entity.getClient());
            res.setDesignation(entity.getDesignation());
            res.setPrixUnitaireHT(entity.getPrixUnitaireHT());
            res.setPrixTVA(entity.getPrixTVA());
            res.setPrixUnitaireTTC(entity.getPrixUnitaireTTC());
        }
        return res;
    }
}
