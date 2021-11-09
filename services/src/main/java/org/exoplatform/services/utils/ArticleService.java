package org.exoplatform.services.utils;

import org.exoplatform.dao.ArticleDao;
import org.exoplatform.dao.ClientDao;
import org.exoplatform.entity.Article;
import org.exoplatform.entity.Client;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

import java.util.List;

public class ArticleService implements ArticleServiceInterface {

    private ArticleDao articleDao;
    private ClientDao clientDao;


    private static final Log LOG = ExoLogger.getExoLogger(Article.class);

    /**
     *
     * @param articleDao
     */
    public ArticleService(ArticleDao articleDao,ClientDao clientDao){
        this.articleDao=articleDao;
        this.clientDao = clientDao;
    }

    @Override
    public Article addArticle(Article a, long id_client) {

        Client client = clientDao.find(id_client);


        Article article = new Article(a.getCodeArticle(),a.getDesignation(),a.getPrixUnitaireHT(),a.getPrixTVA(),a.getPrixUnitaireTTC(),client);
        Article res= null;
        try {
            res = articleDao.create(article);
        }catch (Exception e) {
            LOG.error("Cannot create the article", e);
        }
        return res;
    }

    @Override
    public List<Article> getArticles() {
        return this.articleDao.findAll();
    }

    @Override
    public void deleteArticle(long id) {
        Article article = this.articleDao.find(id);
        try {
            this.articleDao.delete(article);
        }catch (Exception e) {
            LOG.error("Cannot delete the client", e);
        }
    }

    @Override
    public Article updateArticle(long id, Article a) {
        Article article = articleDao.find(id);
        article.setCodeArticle(a.getCodeArticle());
        article.setDesignation(a.getDesignation());
        article.setPrixTVA(a.getPrixTVA());
        article.setPrixUnitaireHT(a.getPrixUnitaireHT());
        article.setPrixUnitaireTTC(a.getPrixUnitaireTTC());
        Article res = null;
        try {
            res =this.articleDao.update(article);
        }catch (Exception e) {
            LOG.error("Cannot update the article", e);
        }
        return res;
    }


}
