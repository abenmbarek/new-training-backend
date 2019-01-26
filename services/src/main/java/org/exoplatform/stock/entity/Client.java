package org.exoplatform.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.exoplatform.commons.api.persistence.ExoEntity;

@Entity
@ExoEntity
@Table( name="CLIENT" )
public class Client{

    @Id
    @Column( name="ID_CLIENT")
    private Long clientId;

    @Column( name="FIRST_NAME_CLIENT")
    private String prenom;

    @Column( name= "NAME_CLIENT")
    private String name;

    @Column( name = "ADDRESS_CLIENT")
    private String adresse;

    @Column( name = "EMAIL_CLIENT")
    private String email;

    /**
     * Default constructor
     */
    public Client() {
    }

    /**
     *
     * @param clientId
     * @param prenom
     * @param name
     * @param adresse
     * @param email
     */
    public Client(Long clientId, String prenom, String name, String adresse, String email) {
        this.clientId = clientId;
        this.prenom = prenom;
        this.name = name;
        this.adresse = adresse;
        this.email = email;
    }

    /**
     *
     * @return the clientId
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     *
     * @return the client name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param clientId
     */

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /***
     *
     * @return the client first name
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return the client address
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @return the client email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /***
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
