package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.LineItemService;

import java.math.BigDecimal;
import java.util.List;

public class TestAddLineItems extends DigitalInvoiceApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(TestAddLineItems.class);

    @Autowired
    LineItemService lineItemService;

    @Test
    public void addLineItems(){

        LOG.info("Testing adding line items");

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

        LOG.info("Lets fetch all Items added: \n ");
        List<LineItem> lineItemList = lineItemService.findAllList();
        LOG.info("Found List: " + lineItemList.toString());

        LOG.info("Getting line Item total: " );
        BigDecimal lineTotal = lineItemService.getLineItemTotal(26L,100L);
        LOG.info("Found item total for invoice:  " + lineTotal);

        LOG.info("Find all Line items for invoice number 100");
        List<LineItem> lineItems = lineItemService.fetchItemsByInvoice(100L);
        LOG.info("Items found : " + lineItems.toString());

        LOG.info("Get Items for an invoive number 100");
        List<LineItem> lineItemList1 = lineItemService.fetchItemsByInvoice(100L);
        LOG.info("Items for invoice number 100 are : " + lineItemList1.toString());
    }
}
