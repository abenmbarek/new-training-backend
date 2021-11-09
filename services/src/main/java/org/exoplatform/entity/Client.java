package org.exoplatform.entity;


import javax.persistence.*;

import java.util.List;

import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity
@ExoEntity
@Table( name="CLIENT" )
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="ID_CLIENT")
    private long clientId;

    @Column( name="FIRST_NAME_CLIENT")
    private String prenom;

    @Column( name= "NAME_CLIENT")
    private String name;

    @Column( name = "ADDRESS_CLIENT")
    private String adresse;

    @Column( name = "EMAIL_CLIENT")
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Article>  Articles;

    public Client(String prenom, String name, String adresse, String email, List<Article> articles) {
        this.clientId = clientId;
        this.prenom = prenom;
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        Articles = articles;
    }
    public Client(String prenom, String name, String adresse, String email) {
        this.clientId = clientId;
        this.prenom = prenom;
        this.name = name;
        this.adresse = adresse;
        this.email = email;
    }
    public Client(){

    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }


}
