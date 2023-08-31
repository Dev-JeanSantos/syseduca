package com.fourtk.syseduca.dto.requesties;

import com.fourtk.syseduca.enums.Segment;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Course;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
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

    private Segment segment;
    private Status status = Status.WAITING;

    public static CourseRequest converterRequest(Course entity) {
        CourseRequest request = new CourseRequest();
        request.setId(entity.getId());
        request.setIdInstitution(entity.getInstitution().getId());
        request.setName(entity.getName());
        request.setDuration(entity.getDuration());
        request.setPeriodicity(entity.getPeriodicity());
        request.setSegment(entity.getSegment());
        request.setStatus(entity.getStatus());
        return request;
    }
}
