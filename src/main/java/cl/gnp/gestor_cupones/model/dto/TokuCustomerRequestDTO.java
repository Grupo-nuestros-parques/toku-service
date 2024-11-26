package cl.gnp.gestor_cupones.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokuCustomerRequestDTO {

    @JsonProperty("government_id")
    private String governmentId;
    private boolean send_mail;
    @JsonProperty("external_id")
    private String externalId;
    private String mail;
    private String name;
    @JsonProperty("phone_number")
    private String phoneNumber;


    public String getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(String governmentId) {
        this.governmentId = governmentId;
    }

    public boolean isSend_mail() {
        return send_mail;
    }

    public void setSend_mail(boolean send_mail) {
        this.send_mail = send_mail;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
