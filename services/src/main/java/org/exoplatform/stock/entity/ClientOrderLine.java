package org.exoplatform.stock.entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;

@Entity
@ExoEntity
@Table(name = "CLIENT_ORDER_LINE")
public class ClientOrderLine {

    @Id
    @Column (name ="ID_CLIENT_ORDER_LINE")
    private Long idClientOrderLine;

    @ManyToOne
    @JoinColumn(name ="ID_CLIENT_ORDER" )
    private ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(name = "ID_ARTICLE")
    private Article article;

    /**
     * default constructor
     */
    public ClientOrderLine() {
    }

    /**
     *
     * @param idClientOrder
     * @param clientOrder
     * @param article
     */
    public ClientOrderLine(Long idClientOrder, ClientOrder clientOrder, Article article) {
        this.idClientOrderLine = idClientOrder;
        this.clientOrder = clientOrder;
        this.article = article;
    }

    /**
     *
     * @return the client id
     */
    public Long getIdClientOrder() {
        return idClientOrderLine;
    }

    /**
     *
     * @return the client order
     */
    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    /**
     *
     * @return the article
     */
    public Article getArticle() {
        return article;
    }

    /**
     *
     * @param idClientOrder
     */
    public void setIdClientOrder(Long idClientOrder) {
        this.idClientOrderLine = idClientOrder;
    }

    /**
     *
     * @param clientOrder
     */
    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    /**
     *
     * @param article
     */
    public void setArticle(Article article) {
        this.article = article;
    }
}
