package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.InvoiceService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class InvoiceController {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Linda Says hello..";
    }

    //Creates a new Invoice
    @PostMapping(value= "invoice", produces= { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> addInvoice(@RequestBody Invoice invoiceInfo, UriComponentsBuilder builder) {

        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceInfo,invoice);
        invoiceService.saveInvoice(invoice);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/invoice/{id}").buildAndExpand(invoice.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Creates a new invoice.. Unconventional way of doing it.. But can get away with murder.
    @GetMapping ("/addInvoice/{invoiceId}/{client}/{vat}")
    public Invoice addInvoice(@PathVariable Long invoiceId, @PathVariable String client, @PathVariable Long vat){
        LOG.info("Create invoice...");
        Invoice invoice = new Invoice(invoiceId,client,vat,new Date());
        invoiceService.saveInvoice(invoice);
        return invoice;
    }

    //Gets all invoices loaded
    @GetMapping("/allInvoices")
    public List<Invoice> viewAllInvoices(){
        List<Invoice> invoiceList = invoiceService.getAllInvoices();
        return invoiceList;
    }

    //View a specific invoice
    @GetMapping("/viewInvoice/{invoiceId}")
    public Invoice viewInvoice(@PathVariable Long invoiceId){
        LOG.info("View Invoice");
        return invoiceService.viewInvoice(invoiceId);
    }

    //Fetches an invoices vat rate
    @GetMapping("/invoiceVat/{invoiceId}")
    public BigDecimal getInvoiceVat(@PathVariable Long invoiceId){
        LOG.info("Get Invoice vat..");
        return invoiceService.getVat(invoiceId).setScale(2, RoundingMode.HALF_UP);
    }

}
