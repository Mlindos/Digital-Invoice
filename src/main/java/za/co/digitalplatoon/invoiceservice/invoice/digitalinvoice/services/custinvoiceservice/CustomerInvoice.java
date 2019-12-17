package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CustomerInvoice {

    private Long invoice;
    private String client;

    private List<InvoiceItems> lineItemList;

    private BigDecimal invoiceTotal;

    private BigDecimal invoiceTax;

    private BigDecimal invoiceGrandTotal;

    public CustomerInvoice(Long invoice, String client, List<InvoiceItems> lineItemList, BigDecimal invoiceTotal, BigDecimal invoiceTax, BigDecimal invoiceGrandTotal) {
        this.invoice = invoice;
        this.client = client;
        this.lineItemList = lineItemList;
        this.invoiceTotal = invoiceTotal;
        this.invoiceTax = invoiceTax;
        this.invoiceGrandTotal = invoiceGrandTotal;
    }

    public CustomerInvoice() {
    }

    @Override
    public String toString() {
        return "CustomerInvoice{" +
                "invoice=" + invoice +
                ", client='" + client + '\'' +
                ", lineItemList=" + lineItemList +
                ", invoiceTotal=" + invoiceTotal +
                ", invoiceTax=" + invoiceTax +
                ", invoiceGrandTotal=" + invoiceGrandTotal +
                '}';
    }

    public Long getInvoice() {
        return invoice;
    }

    public void setInvoice(Long invoice) {
        this.invoice = invoice;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<InvoiceItems> getLineItemList() {
        return lineItemList;
    }

    public void setLineItemList(List<InvoiceItems> lineItemList) {
        this.lineItemList = lineItemList;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getInvoiceTax() {
        return invoiceTax;
    }

    public void setInvoiceTax(BigDecimal invoiceTax) {
        this.invoiceTax = invoiceTax;
    }

    public BigDecimal getInvoiceGrandTotal() {
        return invoiceGrandTotal;
    }

    public void setInvoiceGrandTotal(BigDecimal invoiceGrandTotal) {
        this.invoiceGrandTotal = invoiceGrandTotal;
    }
}
