package com.fourtk.syseduca.dto.requesties;

import com.fourtk.syseduca.models.Institution;

public class InstitutionDTO {

    private Long id;
    private String name;
    private String cnpj;
    private String stateRegistration;
    private String address;
    private String postalCode;
    private String email;
    private String city;
    private char uf;
    private String complement;
    private String phone;

    public InstitutionDTO() {
    }

    public InstitutionDTO(Long id, String name,
                          String cnpj,
                          String stateRegistration,
                          String address,
                          String postalCode,
                          String email,
                          String city,
                          char uf,
                          String complement,
                          String phone) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.stateRegistration = stateRegistration;
        this.address = address;
        this.postalCode = postalCode;
        this.email = email;
        this.city = city;
        this.uf = uf;
        this.complement = complement;
        this.phone = phone;
    }
    public InstitutionDTO(Institution entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cnpj = entity.getCnpj();
        this.stateRegistration = entity.getStateRegistration();
        this.address = entity.getAddress();
        this.postalCode = entity.getPostalCode();
        this.email = entity.getEmail();
        this.city = entity.getCity();
        this.uf = entity.getUf();
        this.complement = entity.getComplement();
        this.phone = entity.getPhone();
    }
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStateRegistration() {
        return stateRegistration;
    }

    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public char getUf() {
        return uf;
    }

    public void setUf(char uf) {
        this.uf = uf;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
