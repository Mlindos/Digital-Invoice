package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.InvoiceService;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice.LineItemService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DigitalInvoiceApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(DigitalInvoiceApplication.class);

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	LineItemService lineItemService;

	public static void main(String[] args) {
		SpringApplication.run(DigitalInvoiceApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{

		LOG.info("Adding Invoices....");
		invoiceService.saveInvoice(new Invoice(10L,"Linda Ndabana",14L,new Date()));
		lineItemService.saveItem(new LineItem(1L,10L,15L,"Bicycle Stand", new BigDecimal(500.55)));

		invoiceService.saveInvoice(new Invoice(15L,"Hugo Mabe",14L,new Date()));
		lineItemService.saveItem(new LineItem(1L,15L,35L,"Hennesy VSOP", new BigDecimal(1500.26)));

		invoiceService.saveInvoice(new Invoice(6L,"Busisiwe Ndabana",11L,new Date()));
		lineItemService.saveItem(new LineItem(5L,6L,65L,"OMO Powder Soap 500ml", new BigDecimal(49.99)));
		lineItemService.saveItem(new LineItem(6L,6L,65L,"OMO Powder Soap 1kg", new BigDecimal(149.99)));

		invoiceService.saveInvoice(new Invoice(8L,"Nontlantla Ndabana",13L,new Date()));
		lineItemService.saveItem(new LineItem(20L,8L,50L,"LEGO batman", new BigDecimal(115.64)));
		lineItemService.saveItem(new LineItem(21L,8L,50L,"LEGO spiderman", new BigDecimal(255.64)));
		lineItemService.saveItem(new LineItem(22L,8L,50L,"LEGO aquaman", new BigDecimal(500.64)));
		lineItemService.saveItem(new LineItem(23L,8L,50L,"LEGO nick fury", new BigDecimal(505.64)));
		lineItemService.saveItem(new LineItem(24L,8L,50L,"LEGO iron man", new BigDecimal(50.64)));


		invoiceService.saveInvoice(new Invoice(100L,"Florence Ndabana",10L,new Date()));
		lineItemService.saveItem(new LineItem(26L,100L,75L,"Laptop Bags", new BigDecimal(25.99)));
		lineItemService.saveItem(new LineItem(27L,100L,105L,"Huawei", new BigDecimal(205.99)));
		lineItemService.saveItem(new LineItem(28L,100L,30L,"Iphone", new BigDecimal(125.99)));

		invoiceService.saveInvoice(new Invoice(7L,"Vole Ndabana",5L,new Date()));
		lineItemService.saveItem(new LineItem(1L,7L,750L,"Brake fluid", new BigDecimal(25.99)));

		invoiceService.saveInvoice(new Invoice(8L,"Nkosinathi Ndabana",10L,new Date()));
		lineItemService.saveItem(new LineItem(1L,8L,50L,"Chalks", new BigDecimal(5.55)));


		List<Invoice> invoiceList = invoiceService.getAllInvoices();
		LOG.info("Invoice added.... : " + invoiceList.toString());


	}

}
