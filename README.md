Project to illustrate the power of Spring.

Spring Boot MVC. This is a simple Invoice and Line Item database structure. This is a maven project and all dependencies have been updated.

Controller RESTful web services to return data. The data is returned in a JSON format.

"/hello" : returns a message 'Linda Says hello..' http://localhost:8080/hello/

"/addInvoice"

"/allInvoices" : returns a list of all invoices loaded. JSON List http://localhost:8080/allInvoices/

"/viewInvoice/{invoiceId}" returns a single invoice for invoice number 10. http://localhost:8080/viewInvoice/10/

"/invoiceVat/{invoiceId}" returns a vat rate set for an invoice http://localhost:8080/invoiceVat/10/

"/custInvoice/{invoiceId}" returns invoice for the customer on invoice number including vat charged and grand total. http://localhost:8080/custInvoice/10/

Reposirory Jpa repository for the entities set.
Entity Available entity's.
Services Services that are exposed to the RestControllers.
