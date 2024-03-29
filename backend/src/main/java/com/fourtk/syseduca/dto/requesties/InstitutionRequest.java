package com.fourtk.syseduca.dto.requesties;

import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.services.validation.CnpjValid;
import com.fourtk.syseduca.services.validation.EmailValid;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@EmailValid
@CnpjValid
public class InstitutionRequest {

    private Long id;

    @Size(min = 5, max = 60, message = "Name must be between 5 and 60 characters")
    @NotBlank(message = "Required field")
    private String name;
    @NotBlank(message = "Required field")
    private String cnpj;
    @NotBlank(message = "Required field")
    private String inep;
    @NotBlank(message = "Required field")
    private String address;
    @NotBlank(message = "Required field")
    private String postalCode;
    @NotBlank(message = "Required field")
    @Email(message = "Enter with valid email")
    private String email;
    @NotBlank(message = "Required field")
    private String city;
    @NotBlank(message = "Required field")
    private String uf;
    private String complement;
    @NotBlank(message = "Required field")
    private String phone;

    public InstitutionRequest() {
    }

    public InstitutionRequest(Long id, String name,
                              String cnpj,
                              String inep,
                              String address,
                              String postalCode,
                              String email,
                              String city,
                              String uf,
                              String complement,
                              String phone) {
        this.id = id;
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
    public InstitutionRequest(Institution entity) {
        this.id = entity.getId();
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

}
