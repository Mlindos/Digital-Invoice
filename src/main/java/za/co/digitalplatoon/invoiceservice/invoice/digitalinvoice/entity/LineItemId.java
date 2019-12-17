package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity;

import java.io.Serializable;

public class LineItemId implements Serializable {

    private Long item;
    private Long invoice;

    public Long getItemId() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public Long getInvoice() {
        return invoice;
    }

    public void setInvoice(Long invoice) {
        this.invoice = invoice;
    }
}
