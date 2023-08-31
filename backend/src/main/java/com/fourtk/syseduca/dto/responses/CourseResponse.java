package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.enums.Segment;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Course;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourseResponse implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String name;
    private Integer duration;
    private String periodicity;
    private Segment segment;
    private Status status;

    private LocalDateTime dateCreate;

    public CourseResponse(String name,
                          Integer duration,
                          String periodicity,
                          Segment segment,
                          Status status,
                          LocalDateTime dateCreate) {
        this.name = name;
        this.duration = duration;
        this.periodicity = periodicity;
        this.segment = segment;
        this.status = status;
        this.dateCreate = dateCreate;
    }

    public CourseResponse(Course entity) {
        this.name = entity.getName();
        this.duration = entity.getDuration();
        this.periodicity = entity.getPeriodicity();
        this.segment = entity.getSegment();
        this.status = entity.getStatus(status);
        this.dateCreate = entity.getDateCreate();
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

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "CourseResponse{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", periodicity='" + periodicity + '\'' +
                ", segment=" + segment +
                ", status=" + status +
                ", dateCreate=" + dateCreate +
                '}';
    }
}
