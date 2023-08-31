package com.fourtk.syseduca.models;

import com.fourtk.syseduca.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

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
    private Set<Course> courses = new HashSet<>();


    @ManyToMany(mappedBy = "teacherLearningDiscipline",
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher> teachers = new ArrayList<>();



    public Discipline() {
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Discipline(Long id,
                      String name,
                      Integer workload,
                      Integer period,
                      String periodicity,
                      Status status) {
        this.id = id;
        this.name = name;
        this.workload = workload;
        this.period = period;
        this.periodicity = periodicity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
