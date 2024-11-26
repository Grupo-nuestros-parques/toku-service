package cl.gnp.gestor_cupones.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TokuInvoiceDTO {
    private String id;
    @JsonProperty("product_id")
    private String productId;//numero_cliente
    private String costumer;
    @JsonProperty("is_paid")
    private boolean isPaid = false;
    @JsonProperty("is_void")
    private boolean isVoid = false;
    private double amount;
    @JsonProperty("due_date")
    private LocalDate dueDate;
    private TokuMetadataDTO metadata;

    @JsonProperty("invoice_external_id")
    private String invoiceExternalId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCostumer() {
        return costumer;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isVoid() {
        return isVoid;
    }

    public void setVoid(boolean aVoid) {
        isVoid = aVoid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TokuMetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(TokuMetadataDTO metadata) {
        this.metadata = metadata;
    }

    public String getInvoiceExternalId() {
        return invoiceExternalId;
    }

    public void setInvoiceExternalId(String invoiceExternalId) {
        this.invoiceExternalId = invoiceExternalId;
    }
}
