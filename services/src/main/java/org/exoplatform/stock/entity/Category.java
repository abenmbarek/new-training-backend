package org.exoplatform.stock.entity;

import javax.persistence.*;

import org.exoplatform.commons.api.persistence.ExoEntity;

import java.util.List;

@Entity
@ExoEntity
@Table(name = "CATEGORY")
public class Category {

  @Id
  @Column(name = "ID_CATEGORY")
  private Long          idCategorye;

  @Column(name = "NAME_CATEGORY")
  private String        libelle;

  @Column(name = "CODE_CATEGORY")
  private String        codeCategorie;

  @OneToMany(mappedBy = "category")
  private List<Article> articles;

  /**
   * The default constructor
   */
  public Category() {
  }

  /**
   * @param id
   * @param libelle
   */
  public Category(Long id, String libelle, String codeCategorie) {
    this.idCategorye = id;
    this.libelle = libelle;
    this.codeCategorie = codeCategorie;
  }

  /**
   * @return the category id
   */

  public Long getIdCategorye() {
    return idCategorye;
  }

  /**
   * @return the category name
   */
  public String getLibelle() {
    return libelle;
  }

  /**
   * @return the category code
   */
  public String getCodeCategorie() {
    return codeCategorie;
  }

  /**
   * @return the articles list of a category
   */

  public List<Article> getArticles() {
    return articles;
  }

  /**
   * @param id
   */
  public void setId(Long id) {
    this.idCategorye = id;
  }

  /**
   * @param libelle
   */
  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  /**
   * @param codeCategorie
   */
  public void setCodeCategorie(String codeCategorie) {
    this.codeCategorie = codeCategorie;
  }

  /**
   * @param articles
   */
  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }
}
