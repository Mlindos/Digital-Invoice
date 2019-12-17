package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.custinvoiceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.repository.InvoiceRepository;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.repository.LineItemRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
public class GetClientInvoice {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    LineItemRepository lineItemRepository;

    public CustomerInvoice getInvoice(Long invoiceNumber){

        Invoice invoice = invoiceRepository.findByInvoiceId(invoiceNumber);
        List<LineItem> lineItemList = lineItemRepository.findByInvoice(invoice.getId());

        List<InvoiceItems> invoiceItems = new ArrayList<>();

        BigDecimal invoiceTotal = new BigDecimal(0.00);

        for(LineItem myLineItem : lineItemList){
            invoiceItems.add(new InvoiceItems(myLineItem.getDescription(),
                                              myLineItem.getQuantity(),
                                              myLineItem.getUnitPrice(),
                                              getTotalPrice(myLineItem.getUnitPrice(),myLineItem.getQuantity())

                    ));
            invoiceTotal =  invoiceTotal.add(getTotalPrice(myLineItem.getUnitPrice(),myLineItem.getQuantity()));
        }

        CustomerInvoice customerInvoice = new CustomerInvoice();
                        customerInvoice.setClient(invoice.getClient());
                        customerInvoice.setInvoice(invoice.getId());
                        customerInvoice.setLineItemList(invoiceItems);
                        customerInvoice.setInvoiceTotal(invoiceTotal);
                        customerInvoice.setInvoiceTax(getInvoiceTax(invoiceTotal));
                        customerInvoice.setInvoiceGrandTotal(calculateGrandTotal(customerInvoice.getInvoiceTotal(),customerInvoice.getInvoiceTax()));
        return customerInvoice;
    }

    private BigDecimal getTotalPrice(BigDecimal unitPrice, Long quantity){
        return unitPrice.multiply(new BigDecimal(quantity)).setScale(2,RoundingMode.HALF_UP);
    }

    private BigDecimal getInvoiceTax(BigDecimal invoiceTotal){
        return invoiceTotal.multiply(new BigDecimal(0.14)).setScale(2,RoundingMode.HALF_UP);
    }

    private BigDecimal calculateGrandTotal(BigDecimal total, BigDecimal vatAmount ){
        return total.add(vatAmount).setScale(2,RoundingMode.HALF_UP);
    }
}
