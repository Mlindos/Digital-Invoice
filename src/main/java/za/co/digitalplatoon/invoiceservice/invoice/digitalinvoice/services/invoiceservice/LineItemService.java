package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.services.invoiceservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.repository.LineItemRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class LineItemService {

    private static final Logger LOG = LoggerFactory.getLogger(LineItemService.class);

    @Autowired
    LineItemRepository lineItemRepository;

    //Saves the invoice details to the table
    public LineItem saveItem(LineItem lineItem){
        return lineItemRepository.save(lineItem);
    }

    public List<LineItem> findAllList(){
        return lineItemRepository.findAll();
    }

    public BigDecimal getLineItemTotal(Long itemId, Long invoiceId){
        LineItem lineItem = new LineItem();
                 lineItem = lineItemRepository.findItemByInvoiceAndItem(itemId, invoiceId);

        BigDecimal  lineItemTotal = lineItem.getUnitPrice().multiply(new BigDecimal(lineItem.getQuantity()));
        return lineItemTotal.setScale(2, RoundingMode.HALF_UP);
    }

//    public List<LineItem> getItemsForInvoice(Long invoiceId){
//        return lineItemRepository.findByInvoice(invoiceId);
//    }

    public List<LineItem> fetchItemsByInvoice(Long invoiceId){
        return lineItemRepository.findByInvoice(invoiceId);
    }
}
