package org.exoplatform.stock.entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ExoEntity
@Table ( name ="SUPPLIER" )
public class Supplier {

    @Id
    @Column ( name="ID_SUPPLIER" )
    private Long id;

    @Column ( name= "FIRST_NAME_SUPPLIER")
    private String firstName;

    @Column ( name= "LAST_NAME_SUPPLIER")
    private String lastName;

    @Column ( name= "ADDRESS_SUPPLIER")
    private String address;

    @Column ( name= "EMAIL_SUPPLIER")
    private String email;


    /**
     * Default constructor
     */
    public Supplier() {
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     */
    public Supplier(Long id, String firstName, String lastName, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    /**
     *
     * @return the supplier id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return the supplier last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return the supplier address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return the supplier name
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
