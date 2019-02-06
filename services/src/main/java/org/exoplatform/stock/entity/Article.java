package org.exoplatform.stock.entity;

import javax.persistence.*;

import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity
@ExoEntity
@Table(name = "ARTICLE")
public class Article {

  @Id
  @Column(name = "ID_ARTICLE")
  private Long     idArticle;

  @Column(name = "CODE_ARTICLE")
  private String   codeArticle;

  @Column(name = "DESIGNATION_ARTICLE")
  private String   designation;

  @Column(name = "PRIX_HT_ARTICLE")
  private Long     prixUnitaireHT;

  @Column(name = "PRIX_TVA_ARTICLE")
  private Long     prixTVA;

  @Column(name = "PRIX_TTC_ARTICLE")
  private Long     prixUnitaireTTC;

  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  /**
   * Default constructor
   */
  public Article() {
  }

  /**
   * @param codeArticle
   * @param designation
   * @param prixUnitaireHT
   * @param prixTVA
   * @param prixUnitaireTTC
   */
  public Article(String codeArticle,
                 String designation,
                 Long prixUnitaireHT,
                 Long prixTVA,
                 Long prixUnitaireTTC,
                 Category category) {
    this.codeArticle = codeArticle;
    this.designation = designation;
    this.prixUnitaireHT = prixUnitaireHT;
    this.prixTVA = prixTVA;
    this.prixUnitaireTTC = prixUnitaireTTC;
    this.category = category;
  }

  /**
   * @return the article id
   */
  public Long getIdArticle() {
    return idArticle;
  }

  /**
   * @return the article code
   */
  public String getCodeArticle() {
    return codeArticle;
  }

  /**
   * @return the article designation
   */
  public String getDesignation() {
    return designation;
  }

  /***
   * @return the article pre-tax prices
   */

  public Long getPrixUnitaireHT() {
    return prixUnitaireHT;
  }

  /**
   * @return the article price tva
   */

  public Long getPrixTVA() {
    return prixTVA;
  }

  /**
   * @return the article price TTC
   */
  public Long getPrixUnitaireTTC() {
    return prixUnitaireTTC;
  }

  /**
   * @return the category of an article
   */
  public Category getCategory() {
    return category;
  }

  /**
   * @param idArticle
   */
  public void setIdArticle(Long idArticle) {
    this.idArticle = idArticle;
  }

  /**
   * @param codeArticle
   */
  public void setCodeArticle(String codeArticle) {
    this.codeArticle = codeArticle;
  }

  /**
   * @param designation
   */
  public void setDesignation(String designation) {
    this.designation = designation;
  }

  /**
   * @param prixUnitaireHT
   */
  public void setPrixUnitaireHT(Long prixUnitaireHT) {
    this.prixUnitaireHT = prixUnitaireHT;
  }

  /**
   * @param prixTVA
   */
  public void setPrixTVA(Long prixTVA) {
    this.prixTVA = prixTVA;
  }

  /**
   * @param prixUnitaireTTC
   */
  public void setPrixUnitaireTTC(Long prixUnitaireTTC) {
    this.prixUnitaireTTC = prixUnitaireTTC;
  }

  /**
   * @param category
   */
  public void setCategory(Category category) {
    this.category = category;
  }
}
