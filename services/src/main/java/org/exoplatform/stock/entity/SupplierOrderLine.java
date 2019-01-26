package org.exoplatform.stock.entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;

@Entity
@ExoEntity
@Table(name = "SUPPLIER_ORDER_LINE")
public class SupplierOrderLine {

    @Id
    @Column(name="ID_SUPPLIER_ORDER_LINE")
    private Long idSupplierOrderLine;

    @ManyToOne
    @JoinColumn(name ="ID_SUPPLIER")
    private SupplierOrder supplierOrder;

    @ManyToOne
    private  Article article;

    /**
     * Default constructor
     */
    public SupplierOrderLine() {
    }

    /**
     *
     * @param idSupplierOrderLine
     * @param supplierOrder
     * @param article
     */
    public SupplierOrderLine(Long idSupplierOrderLine, SupplierOrder supplierOrder, Article article) {
        this.idSupplierOrderLine = idSupplierOrderLine;
        this.supplierOrder = supplierOrder;
        this.article = article;
    }

    /**
     *
     * @return the id supplier order line
     */
    public Long getIdSupplierOrderLine() {
        return idSupplierOrderLine;
    }

    /**
     *
     * @return the supplier order
     */
    public SupplierOrder getSupplierOrder() {
        return supplierOrder;
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
     * @param idSupplierOrderLine
     */
    public void setIdSupplierOrderLine(Long idSupplierOrderLine) {
        this.idSupplierOrderLine = idSupplierOrderLine;
    }

    /**
     *
     * @param supplierOrder
     */
    public void setSupplierOrder(SupplierOrder supplierOrder) {
        this.supplierOrder = supplierOrder;
    }

    /**
     *
     * @param article
     */
    public void setArticle(Article article) {
        this.article = article;
    }
}
