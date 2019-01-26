package org.exoplatform.stock.entity;

import org.exoplatform.commons.api.persistence.ExoEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@ExoEntity
@Table (name = "SUPPLIER_ORDER")
public class SupplierOrder {

    @Id
    @Column(name="ID_SUPPLIER_ORDER")
    private Long idSupplierOrder;

    @Column (name="CODE_SUPPLIER")
    private String codeSupplier;

    @Column (name = "DATE_SUPPLIER_ORDER")
    private Date dateSupplierOrder;

    @OneToMany(mappedBy = "supplierOrder")
    private List<SupplierOrderLine>  supplierOrderLines;

    @ManyToOne
    @JoinColumn(name = "ID_SUPPLIER")
    private Supplier supplier;


    /**
     * Default constructor
     */
    public SupplierOrder() {
    }

    /**
     *
     * @param idSupplierOrder
     * @param codeSupplier
     * @param dateSupplierOrder
     * @param supplierOrderLines
     * @param supplier
     */
    public SupplierOrder(Long idSupplierOrder, String codeSupplier, Date dateSupplierOrder, List<SupplierOrderLine> supplierOrderLines, Supplier supplier) {
        this.idSupplierOrder = idSupplierOrder;
        this.codeSupplier = codeSupplier;
        this.dateSupplierOrder = dateSupplierOrder;
        this.supplierOrderLines = supplierOrderLines;
        this.supplier = supplier;
    }

    /**
     *
     * @return the id supplier
     */
    public Long getIdSupplier() {
        return idSupplierOrder;
    }

    /**
     *
     * @return the supplier code
     */
    public String getCodeSupplier() {
        return codeSupplier;
    }

    /**
     *
     * @return the supplier order date
     */
    public Date getDateSupplierOrder() {
        return dateSupplierOrder;
    }

    /**
     *
     * @return the supplier order line
     */
    public List<SupplierOrderLine> getSupplierOrderLines() {
        return supplierOrderLines;
    }

    /**
     *
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     *
     * @param idSupplierOrder
     */
    public void setIdSupplier(Long idSupplierOrder) {
        this.idSupplierOrder = idSupplierOrder;
    }

    /**
     *
     * @param codeSupplier
     */
    public void setCodeSupplier(String codeSupplier) {
        this.codeSupplier = codeSupplier;
    }

    /**
     *
     * @param dateSupplierOrder
     */
    public void setDateSupplierOrder(Date dateSupplierOrder) {
        this.dateSupplierOrder = dateSupplierOrder;
    }

    /**
     *
     * @param supplierOrderLines
     */
    public void setSupplierOrderLines(List<SupplierOrderLine> supplierOrderLines) {
        this.supplierOrderLines = supplierOrderLines;
    }

    /**
     *
     * @param supplier
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
