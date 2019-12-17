package za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.co.digitalplatoon.invoiceservice.invoice.digitalinvoice.entity.Invoice;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long > {


    @Query("select i from Invoice i where i.invoice = :invoice")
    Invoice findByInvoiceId(@Param("invoice") Long invoice);

    List<Invoice> findByInvoice(Long invoice);
    List<Invoice> findByInvoiceDate(Date date);

}
