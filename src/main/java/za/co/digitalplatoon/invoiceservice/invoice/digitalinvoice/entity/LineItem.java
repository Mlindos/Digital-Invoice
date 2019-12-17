package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="LineItem")
@IdClass(LineItemId.class)
public class LineItem implements Serializable {

    @Id
    @Column(name="ItemId")
    private Long item;

    @Id
    @Column(name="InvoiceId")
    private Long invoice;

    @Column(name="Quantity")
    private Long quantity;

    @Column(name="Description")
    private String description;

    @Column(name="UnitPrice")
    private BigDecimal unitPrice;

    public LineItem(Long item, Long invoice, Long quantity, String description, BigDecimal unitPrice) {
        this.item = item;
        this.invoice = invoice;
        this.quantity = quantity;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public LineItem() {
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "item=" + item +
                ", invoice=" + invoice +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public Long getItem() {
        return item;
    }

    public void setItemId(Long item) {
        this.item = item;
    }

    public Long getInvoice() {
        return invoice;
    }

    public void setInvoice(Long invoice) {
        this.invoice = invoice;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }



}
