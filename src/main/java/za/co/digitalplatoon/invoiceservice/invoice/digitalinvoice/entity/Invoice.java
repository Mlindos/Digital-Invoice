package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//@Data  //Sets the getters and setters
@Entity
@Table(name="Invoice")
public class Invoice {

    @Id
    @Column(name="InvoiceId")
    private Long invoice;

    @Column(name="Client")
    private String client;

    @Column(name="VatRate")
    private Long vatRate;

    @Column(name="InvoiceDate")
    private Date invoiceDate;


    public Long getId() {
        return invoice;
    }

    public void setId(Long invoice) {
        this.invoice = invoice;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public void setVatRate(Long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice=" + invoice +
                ", client='" + client + '\'' +
                ", vatRate=" + vatRate +
                ", invoiceDate=" + invoiceDate +
                '}';
    }

    public Invoice(Long invoice, String client, Long vatRate, Date invoiceDate) {
        this.invoice = invoice;
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
    }

    public Invoice() {
    }
}
