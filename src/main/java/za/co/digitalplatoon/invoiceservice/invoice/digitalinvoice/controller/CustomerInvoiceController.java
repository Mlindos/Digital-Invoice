package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.DigitalInvoiceApplication;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice.CustomerInvoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice.GetClientInvoice;

@RestController
public class CustomerInvoiceController {

    private static final Logger LOG = LoggerFactory.getLogger(DigitalInvoiceApplication.class);

    @Autowired
    private GetClientInvoice getClientInvoice;

    @GetMapping("/custInvoice/{invoiceId}")
    public CustomerInvoice fetchCustInvoice(@PathVariable Long invoiceId){
           LOG.info("Customer Invoice..");
           CustomerInvoice customerInvoice  = getClientInvoice.getInvoice(invoiceId);
           return customerInvoice;
    }
}
