package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class InvoiceService {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    LineItemService lineItemService;

    //Saves the invoice details to the table
    public Invoice saveInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    //Gets all invoices from the table
    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }

    //Gets one invoice from the table
    public Invoice viewInvoice(Long invoiceId){
        return invoiceRepository.findByInvoiceId(invoiceId);
    }

    //Get the sub-total amount for a given invoice i.e Amount before tax..
    public BigDecimal getSubTotal(Long invoiceId){

        //Get the total value per line item
        List<LineItem> lineItemList = lineItemService.fetchItemsByInvoice(invoiceId);

        BigDecimal subTotal = new BigDecimal(0.00);

        for(LineItem myLineItems : lineItemList){
           subTotal = subTotal.add(myLineItems.getUnitPrice().multiply(new BigDecimal(myLineItems.getQuantity())));
        }
        return subTotal.setScale(2, RoundingMode.HALF_UP);
    }

    //This will be the vat rate set for the invoice. Some invoices can be charged higher vat while others might be waved..
    public BigDecimal getVat(Long invoiceId){
        Invoice invoice = invoiceRepository.findByInvoiceId(invoiceId);
        return BigDecimal.valueOf(invoice.getVatRate());
    }

    //This is the total price for the bill
    public BigDecimal getTotal(Long invoiceId){

        BigDecimal subTotal = getSubTotal(invoiceId),
                   vatRate  = getVat(invoiceId);

        return subTotal.multiply(vatRate).setScale(2,RoundingMode.HALF_UP);
    }
}
