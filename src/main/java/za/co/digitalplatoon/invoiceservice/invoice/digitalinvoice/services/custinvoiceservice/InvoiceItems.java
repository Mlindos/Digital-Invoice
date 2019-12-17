package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceItems {

    private String description;

    private Long quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public InvoiceItems(String description, Long quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }
}
