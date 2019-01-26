package org.exoplatform.stock.entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@ExoEntity
@Table (name="CLIENT_ORDER")
public class ClientOrder {

    @Id
    @Column (name = "ID_CLIENT_ORDER")
    private Long idClientOrder;

    @Column(name = "CODE_CLIENT_ORDER")
    private String code;

    @Column(name="DATE_CLIENT_ORDER")
    private Date dateOrder;

    @OneToMany(mappedBy = "clientOrder")
    private List<ClientOrderLine> clientOrderLine;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;


    /***
     * Default constructor
     */
    public ClientOrder() {
    }

    /**
     *
     * @param idClientOrder
     * @param code
     * @param dateOrder
     * @param clientOrderLine
     * @param client
     */
    public ClientOrder(Long idClientOrder, String code, Date dateOrder, List<ClientOrderLine> clientOrderLine, Client client) {
        this.idClientOrder = idClientOrder;
        this.code = code;
        this.dateOrder = dateOrder;
        this.clientOrderLine = clientOrderLine;
        this.client = client;
    }

    /**
     *
     * @return the client id
     */

    public Long getIdClientOrder() {
        return idClientOrder;
    }

    /**
     *
     * @return the client code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return the client order date
     */
    public Date getDateOrder() {
        return dateOrder;
    }

    /**
     *
     * @return the client order line
     */
    public List<ClientOrderLine> getClientOrderLine() {
        return clientOrderLine;
    }

    /**
     *
     * @return the client order
     */
    public Client getClient() {
        return client;
    }

    /**
     *
     * @param idClientOrder
     */
    public void setIdClientOrder(Long idClientOrder) {
        this.idClientOrder = idClientOrder;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @param dateOrder
     */
    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    /**
     *
     * @param clientOrderLine
     */
    public void setClientOrderLine(List<ClientOrderLine> clientOrderLine) {
        this.clientOrderLine = clientOrderLine;
    }

    /**
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
