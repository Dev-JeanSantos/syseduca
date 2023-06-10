package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Discipline;

import java.io.Serializable;

public class DisciplineResponse implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String name;

    private Integer workload;

    private Integer period;

    private String periodicity;

    private Status status = Status.ACTIVE;

    public DisciplineResponse() {
    }

    public DisciplineResponse(String name,
                              Integer workload,
                              Integer period,
                              String periodicity,
                              Status status) {
        this.name = name;
        this.workload = workload;
        this.period = period;
        this.periodicity = periodicity;
        this.status = status;
    }

    public DisciplineResponse(Discipline entity) {
        this.name = entity.getName();
        this.workload = entity.getWorkload();
        this.period = entity.getPeriod();
        this.periodicity = entity.getPeriodicity();
        this.status = entity.getStatus();
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
        return "DisciplineResponse{" +
                "name='" + name + '\'' +
                ", workload=" + workload +
                ", period=" + period +
                ", periodicity='" + periodicity + '\'' +
                ", status=" + status +
                '}';
    }
}
