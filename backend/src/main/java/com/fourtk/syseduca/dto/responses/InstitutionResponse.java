package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.services.validation.CnpjValid;
import com.fourtk.syseduca.services.validation.EmailValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@EmailValid
@CnpjValid
public class InstitutionResponse {
    private String name;
    private String cnpj;
    private String inep;
    private String address;
    private String postalCode;
    private String email;
    private String city;
    private String uf;
    private String complement;
    private String phone;

    public InstitutionResponse() {
    }

    public InstitutionResponse(String name,
                               String cnpj,
                               String inep,
                               String address,
                               String postalCode,
                               String email,
                               String city,
                               String uf,
                               String complement,
                               String phone) {
        this.name = name;
        this.cnpj = cnpj;
        this.inep = inep;
        this.address = address;
        this.postalCode = postalCode;
        this.email = email;
        this.city = city;
        this.uf = uf;
        this.complement = complement;
        this.phone = phone;
    }
    public InstitutionResponse(Institution entity) {
        this.name = entity.getName();
        this.cnpj = entity.getCnpj();
        this.inep = entity.getInep();
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
    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInep() {
        return inep;
    }

    public void setInep(String inep) {
        this.inep = inep;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
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

    @Override
    public String toString() {
        return "InstitutionResponse{" +
                "name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", inep='" + inep + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", uf='" + uf + '\'' +
                ", complement='" + complement + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
