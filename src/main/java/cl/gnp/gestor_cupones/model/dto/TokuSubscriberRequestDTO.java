package cl.gnp.gestor_cupones.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokuSubscriberRequestDTO {

    @JsonProperty("customer")
    private String customer;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("pac_mandate_id")
    private String pacMandateId;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPacMandateId() {
        return pacMandateId;
    }

    public void setPacMandateId(String pacMandateId) {
        this.pacMandateId = pacMandateId;
    }
}
