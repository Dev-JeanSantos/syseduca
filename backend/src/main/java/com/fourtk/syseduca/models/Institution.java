package com.fourtk.syseduca.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(mappedBy = "institution",  fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();
}
