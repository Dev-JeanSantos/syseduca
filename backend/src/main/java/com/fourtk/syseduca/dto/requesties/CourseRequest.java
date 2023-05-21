package com.fourtk.syseduca.dto.requesties;

import com.fourtk.syseduca.models.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CourseRequest implements Serializable {

    private static final Long serialVersionUID = 1L;
    private Long id;

    @NotNull
    private Long idInstitution;

    @Size(min = 5, max = 60, message = "Name must be between 5 and 60 characters")
    @NotBlank(message = "Required field")
    private String name;

    @NotNull(message = "Required field")
    private Integer duration;

    @NotBlank(message = "Required field")
    private String periodicity;

    private boolean status = true;


    public CourseRequest(Long id, Long idInstitution, String name, Integer duration, String periodicity, boolean status) {
        this.id = id;
        this.idInstitution = idInstitution;
        this.name = name;
        this.duration = duration;
        this.periodicity = periodicity;
        this.status = status;
    }

    public CourseRequest(Course entity) {
        this.id = entity.getId();
        this.idInstitution = entity.getId();
        this.name = entity.getName();
        this.duration = entity.getDuration();
        this.periodicity = entity.getPeriodicity();
        this.status = entity.isStatus();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Long idInstitution) {
        this.idInstitution = idInstitution;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
