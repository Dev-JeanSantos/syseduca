package com.fourtk.syseduca.models;

import com.fourtk.syseduca.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "photo_id")
    private Photo photo;


    private Long permissionId;
    private String name;
    private Genre genre;
    private String nationality;
    private String naturalness;
    private String naturalnessUF;
    private LocalDateTime birthDate;
    private String civilRegister;
    private String civilRegisterOffice;
    private String civilRegisterUF;
    private LocalDateTime dateIssueCivilRegister;
    private String cpf;
    private String email;
    private String fatherName;
    private String motherName;
    private String cep;
    private String address;
    private String addressNumber;
    private String addressComplement;
    private String neighborhood;
    private String city;
    private String state;
    private String phone;
    private String phoneCell;
    private String password;
    private String userStatus;

    @OneToMany(mappedBy = "user",  fetch = FetchType.EAGER)
    private List<Teacher> teachers = new ArrayList<>();




}
