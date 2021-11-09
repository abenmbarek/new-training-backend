package org.exoplatform.services.utils;

import org.exoplatform.entity.Article;
import org.exoplatform.entity.Client;

import java.util.List;

public interface ArticleServiceInterface {

    Article addArticle(Article a, long id);
    List<Article> getArticles();
    void deleteArticle(long id);
    Article updateArticle(long id,Article a);
}
