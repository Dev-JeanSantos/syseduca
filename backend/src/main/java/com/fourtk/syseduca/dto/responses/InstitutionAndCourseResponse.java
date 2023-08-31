package com.fourtk.syseduca.dto.responses;

import com.fourtk.syseduca.models.Institution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class InstitutionAndCourseResponse {

    private String name;
    private String inep;
    private List<CourseResponse> courses;

    public static InstitutionAndCourseResponse converter(Institution institution) {
        InstitutionAndCourseResponse institutionAndCourseResponse = new InstitutionAndCourseResponse();
        institutionAndCourseResponse.setName(institution.getName());
        institutionAndCourseResponse.setInep(institution.getInep());
        institutionAndCourseResponse.setCourses(
                institution.getCourses().stream().map(CourseResponse::converterCourseResponse).collect(Collectors.toList()));
        return institutionAndCourseResponse;
    }
}
