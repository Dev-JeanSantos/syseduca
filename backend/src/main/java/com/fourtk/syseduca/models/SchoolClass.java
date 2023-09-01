package com.fourtk.syseduca.models;

import com.fourtk.syseduca.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_school_class")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer classYear;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @ManyToMany(mappedBy = "teacherAlocatedClassroom",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany(mappedBy = "disciplineAlocatedClassroom",
            fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Discipline> disciplines = new ArrayList<>();

}
