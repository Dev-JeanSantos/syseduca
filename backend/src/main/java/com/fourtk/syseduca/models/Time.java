package com.fourtk.syseduca.models;

import com.fourtk.syseduca.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayWeek;
    private String timeDay;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolClass schoolClass;
}
