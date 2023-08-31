package com.fourtk.syseduca.dto.requesties;

import com.fourtk.syseduca.models.Discipline;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class DisciplineUpdateRequest {
    @Size(min = 5, max = 60, message = "Name must be between 5 and 60 characters")
    @NotBlank(message = "Required field")
    private String name;

    @NotNull(message = "Required field")
    private Integer workload;

    @NotNull(message = "Required field")
    private Integer period;

    @NotBlank(message = "Required field")
    private String periodicity;


    public DisciplineUpdateRequest() {
    }

    public DisciplineUpdateRequest(String name,
                                   Integer workload,
                                   Integer period,
                                   String periodicity) {
        this.name = name;
        this.workload = workload;
        this.period = period;
        this.periodicity = periodicity;
    }

    public DisciplineUpdateRequest(Discipline entity) {
        this.name = entity.getName();
        this.workload = entity.getWorkload();
        this.period = entity.getPeriod();
        this.periodicity = entity.getPeriodicity();
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

    @Override
    public String toString() {
        return "DisciplineRequest{" +
                ", name='" + name + '\'' +
                ", workload=" + workload +
                ", period=" + period +
                ", periodicity='" + periodicity + '\'' +
                '}';
    }
}
