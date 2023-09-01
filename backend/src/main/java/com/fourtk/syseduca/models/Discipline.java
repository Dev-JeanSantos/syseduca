package com.fourtk.syseduca.models;

import com.fourtk.syseduca.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_discipline")
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 60, message = "Name must be between 5 and 60 characters")
    @NotBlank(message = "Required field")
    private String name;

    @NotNull(message = "Required field")
    private Integer workload;

    @NotNull(message = "Required field")
    private Integer period;

    @NotBlank(message = "Required field")
    private String periodicity;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @ManyToMany(mappedBy = "disciplines",
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();


    @ManyToMany(mappedBy = "teacherLearningDiscipline",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany
    @JoinTable( name = "tb_schoolclass_discipline",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "school_class_id"))
    List<SchoolClass> disciplineAlocatedClassroom = new ArrayList<>();

}
