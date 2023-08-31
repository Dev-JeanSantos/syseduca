package com.fourtk.syseduca.dto.requesties;

import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Discipline;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DisciplineRequest {

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

    private Status status = Status.ACTIVE;

    public DisciplineRequest() {
    }

    public DisciplineRequest(Long id,
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

    public DisciplineRequest(Discipline entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.workload = entity.getWorkload();
        this.period = entity.getPeriod();
        this.periodicity = entity.getPeriodicity();
        this.status = entity.getStatus();
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
    public String toString() {
        return "DisciplineRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workload=" + workload +
                ", period=" + period +
                ", periodicity='" + periodicity + '\'' +
                ", status=" + status +
                '}';
    }
}
