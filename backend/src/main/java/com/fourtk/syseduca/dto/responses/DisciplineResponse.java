package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Discipline;
import lombok.Data;

import java.io.Serializable;

@Data
public class DisciplineResponse implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String name;

    private Integer workload;

    private Integer period;

    private String periodicity;

    private Status status = Status.ACTIVE;

    public static DisciplineResponse converterDisciplineResponse(Discipline entity) {
        DisciplineResponse response = new DisciplineResponse();
        response.setName(entity.getName());
        response.setWorkload(entity.getWorkload());
        response.setPeriod(entity.getPeriod());
        response.setPeriodicity(entity.getPeriodicity());
        response.setStatus(entity.getStatus());
        return response;
    }
}
