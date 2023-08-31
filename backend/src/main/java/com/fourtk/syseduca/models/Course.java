package com.fourtk.syseduca.models;

import com.fourtk.syseduca.enums.Segment;
import com.fourtk.syseduca.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer duration;

    private String periodicity;

    @Enumerated(EnumType.STRING)
    private Segment segment;


    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToMany
    @JoinTable( name = "tb_course_discipline",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    Set<Discipline> disciplines = new HashSet<>();

    private LocalDateTime dateCreate  = LocalDateTime.now();

    public Course() {
    }

    public Course(Long id,
                  String name,
                  Integer duration,
                  String periodicity,
                  Segment segment,
                  Status status,
                  Institution institution,
                  LocalDateTime dateCreate) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.periodicity = periodicity;
        this.segment = segment;
        this.status = Status.WAITING;
        this.institution = institution;
        this.dateCreate = dateCreate;

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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Status getStatus(Status status) {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
