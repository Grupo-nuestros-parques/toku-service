package cl.gnp.gestor_cupones.model.dto;

public class TokuSubscriberResponseDTO {
    private String id;
    private String productId;
    private String customer;
    private String pacMandateId;
    private boolean isRecurring;
    private double amount;

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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPacMandateId() {
        return pacMandateId;
    }

    public void setPacMandateId(String pacMandateId) {
        this.pacMandateId = pacMandateId;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
