package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice.CustomerInvoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice.GetClientInvoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.InvoiceService;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.LineItemService;

import java.math.BigDecimal;
import java.util.Date;

public class CreateCustomerInvoice extends DigitalInvoiceApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerInvoice.class);

    @Autowired
    InvoiceService invoiceService;

    @Autowired
    LineItemService lineItemService;

    @Autowired
    GetClientInvoice getClientInvoice;

    @Test
    public void createCustInvoice(){

        LOG.info(" - - - - - > Creating Invoice");
        Invoice invoice = new Invoice();
        invoice.setId(100L);
        invoice.setClient("Linda Ndabana");
        invoice.setInvoiceDate(new Date());
        invoice.setVatRate(10L);
        invoiceService.saveInvoice(invoice);

        LOG.info("Now Adding line items");
        //(Long item, Long invoice, Long quantity, String description, BigDecimal unitPrice)
        LineItem lineItem = new LineItem(10L,100L,15L,"Bicycle Stand", new BigDecimal(500.55));
        lineItemService.saveItem(lineItem);

        //(Long item, Long invoice, Long quantity, String description, BigDecimal unitPrice)
        LineItem lineItem2 = new LineItem(15L,100L,35L,"Hennesy VSOP", new BigDecimal(1500.26));
        lineItemService.saveItem(lineItem2);

        //(Long item, Long invoice, Long quantity, String description, BigDecimal unitPrice)
        LineItem lineItem3 = new LineItem(6L,100L,65L,"OMO Powder Soap", new BigDecimal(49.99));
        lineItemService.saveItem(lineItem3);

        //(Long item, Long invoice, Long quantity, String description, BigDecimal unitPrice)
        LineItem lineItem4 = new LineItem(8L,100L,50L,"LEGO", new BigDecimal(5.64));
        lineItemService.saveItem(lineItem4);

        //(Long item, Long invoice, Long quantity, String description, BigDecimal unitPrice)
        LineItem lineItem5 = new LineItem(26L,100L,75L,"Laptop Bags", new BigDecimal(25.99));
        lineItemService.saveItem(lineItem5);

        CustomerInvoice customerinvoice = new CustomerInvoice();
                        customerinvoice = getClientInvoice.getInvoice(100L);
        LOG.info("Customer invoice: " + customerinvoice.toString());

    }
}
