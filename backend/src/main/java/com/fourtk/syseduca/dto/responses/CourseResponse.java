package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.enums.Segment;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Course;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CourseResponse{
    private String name;
    private Integer duration;
    private String periodicity;
    private Segment segment;
    private Status status;

    private LocalDateTime dateCreate;

    public static CourseResponse converterCourseResponse(Course entity) {
        CourseResponse response = new CourseResponse();
        response.setName(entity.getName());
        response.setDuration(entity.getDuration());
        response.setPeriodicity(entity.getPeriodicity());
        response.setSegment(entity.getSegment());
        response.setStatus(entity.getStatus());
        response.setDateCreate(entity.getDateCreate());
        return response;
    }
    
}
