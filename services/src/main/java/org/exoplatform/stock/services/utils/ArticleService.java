package org.exoplatform.stock.services.utils;

import java.util.List;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.stock.dao.ArticleDao;
import org.exoplatform.stock.dao.CategoryDao;
import org.exoplatform.stock.entity.Article;
import org.exoplatform.stock.entity.Category;

public class ArticleService {

  private ArticleDao       articleDao;

  private CategoryDao      categoryDao;

  private static final Log LOG = ExoLogger.getExoLogger(Article.class);

  /**
   * @param articleDao
   * @param categoryDao
   */
  public ArticleService(ArticleDao articleDao, CategoryDao categoryDao) {
    this.articleDao = articleDao;
    this.categoryDao = categoryDao;
  }

    /**
     *
     * @param codeArticle
     * @param designation
     * @param prixUnitaireHT
     * @param prixTVA
     * @param prixUnitaireTTC
     * @param category
     * @return the new article or null if failed
     */
  public Article addArticle(String codeArticle,
                            String designation,
                            Long prixUnitaireHT,
                            Long prixTVA,
                            Long prixUnitaireTTC,
                            Category category) {

      Article addArticle=null;
       if (!codeArticle.equals("") && (!designation.equals("")) && (prixUnitaireHT == null) && (prixTVA == null)
        && (prixUnitaireTTC == null) && (category == null)) {
           Article article = new Article(codeArticle, designation, prixUnitaireHT, prixTVA, prixUnitaireTTC, category);
           try {
               addArticle = articleDao.create(article);
           } catch (Exception e) {
               LOG.error("Cannot create the article", e);
           }
       }
        return addArticle;
  }

    /**
     *
     * @param id
     */
  public void deleteArticle(Long id)
  {
     Article article=articleDao.find(id);
     if(article != null)
     {
         articleDao.delete(article);
     }
  }
  public List<Article> getAllArticle()
  {
        return articleDao.findAll();
  }

}
