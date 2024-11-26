package cl.gnp.gestor_cupones.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokuCustomerResponseDTO {
    private String id;
    @JsonProperty("government_id")
    private String governmentId;
    private boolean send_mail;
    @JsonProperty("external_id")
    private String externalId;
    private String mail;
    private String name;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("pac_mandate_id")
    private String pacMandateId;
    @JsonProperty("default_agent")
    private String defaultAgent;
    @JsonProperty("agent_phone_number")
    private String agentPhoneNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPacMandateId() {
        return pacMandateId;
    }

    public void setPacMandateId(String pacMandateId) {
        this.pacMandateId = pacMandateId;
    }

    public String getDefaultAgent() {
        return defaultAgent;
    }

    public void setDefaultAgent(String defaultAgent) {
        this.defaultAgent = defaultAgent;
    }

    public String getAgentPhoneNumber() {
        return agentPhoneNumber;
    }

    public void setAgentPhoneNumber(String agentPhoneNumber) {
        this.agentPhoneNumber = agentPhoneNumber;
    }
}
