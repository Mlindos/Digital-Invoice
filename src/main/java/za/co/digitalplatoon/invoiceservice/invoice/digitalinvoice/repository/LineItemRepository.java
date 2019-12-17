package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.LineItem;

import java.util.List;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {

    //List<LineItem> findByItem(Long item);

    //List<LineItem> findByItemAndInvoice(Long item, Long invoice);

    List<LineItem> findByInvoice(Long invoice);

    @Query("select a from LineItem a where a.item = :item and a.invoice = :invoice")
    LineItem findItemByInvoiceAndItem(@Param("item") Long item, @Param("invoice") Long invoice);
}
