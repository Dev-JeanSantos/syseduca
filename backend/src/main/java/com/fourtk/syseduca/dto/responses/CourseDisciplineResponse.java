package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Course;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CourseDisciplineResponse {
    private String name;
    private Integer duration;
    private Status status;
    private LocalDateTime dateCreate;
    private List<DisciplineResponse> disciplines = new ArrayList<>();

    public static CourseDisciplineResponse converterCourseResponse(Course entity) {
        CourseDisciplineResponse response = new CourseDisciplineResponse();
        response.setName(entity.getName());
        response.setDuration(entity.getDuration());
        response.setStatus(entity.getStatus());
        response.setDateCreate(entity.getDateCreate());
        response.setDisciplines(
                entity.getDisciplines().stream().map(DisciplineResponse::converterDisciplineResponse).collect(Collectors.toList())
        );
        return response;
    }
    
}
