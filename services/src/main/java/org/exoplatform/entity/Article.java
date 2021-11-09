package org.exoplatform.entity;

import javax.persistence.*;

import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity
@ExoEntity
@Table( name="ARTICLE" )
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID_CLIENT")
    private Client client;

    public Article(String codeArticle, String designation, Long prixUnitaireHT, Long prixTVA, Long prixUnitaireTTC, Client client) {
        this.codeArticle = codeArticle;
        this.designation = designation;
        this.prixUnitaireHT = prixUnitaireHT;
        this.prixTVA = prixTVA;
        this.prixUnitaireTTC = prixUnitaireTTC;
        this.client = client;
    }

    public Article (){

    }
    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    public void setPrixUnitaireHT(Long prixUnitaireHT) {
        this.prixUnitaireHT = prixUnitaireHT;
    }

    public Long getPrixTVA() {
        return prixTVA;
    }

    public void setPrixTVA(Long prixTVA) {
        this.prixTVA = prixTVA;
    }

    public Long getPrixUnitaireTTC() {
        return prixUnitaireTTC;
    }

    public void setPrixUnitaireTTC(Long prixUnitaireTTC) {
        this.prixUnitaireTTC = prixUnitaireTTC;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
