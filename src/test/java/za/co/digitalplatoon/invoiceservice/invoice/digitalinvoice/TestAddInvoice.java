package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.InvoiceService;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.LineItemService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TestAddInvoice extends DigitalInvoiceApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(TestAddInvoice.class);

    @Autowired
    InvoiceService invoiceService;

    @Test
    public void testAddInvoice(){

        LOG.info(" - - - - - > Testing Adding Invoice");
        Invoice invoice = new Invoice();
        invoice.setId(100L);
        invoice.setClient("Linda Ndabana");
        invoice.setInvoiceDate(new Date());
        invoice.setVatRate(10L);

        invoiceService.saveInvoice(invoice);

        LOG.info(" - - - - > Now fetch the data");
        List<Invoice> invoiceList = invoiceService.getAllInvoices();
        LOG.info("Using the get-all(): invoice list is: " + invoiceList.toString());

        LOG.info(" - - - - > Get one" );
        Invoice invoice1 = invoiceService.viewInvoice(100L);
        LOG.info("View Invoice : " + invoice1.toString());

        LOG.info(" - - - - > Get vat rate");
        BigDecimal vatRate = invoiceService.getVat(100L);
        LOG.info("Vate Rate for invoice : " + vatRate);
    }
}
