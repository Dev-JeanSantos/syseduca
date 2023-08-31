package com.fourtk.syseduca.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlPhoto;

    @OneToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;




}
