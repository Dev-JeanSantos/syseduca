package com.fourtk.syseduca.services;

import com.fourtk.syseduca.dto.requesties.CourseRequest;
import com.fourtk.syseduca.dto.requesties.InstitutionRequest;
import com.fourtk.syseduca.dto.responses.CourseResponse;
import com.fourtk.syseduca.dto.responses.InstitutionResponse;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.vos.CoursesOfInstitutionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICourseService {

    public CourseRequest insert(CourseRequest request);

    public Page<CourseResponse> findAllPaged(PageRequest pageRequest);

    public CourseResponse findById(Long id);

    public CourseRequest update(Long id, CourseRequest dto);

    public void updateStatus(Long id, Status status);

    public void delete(Long id);

    public Page<CourseResponse> coursesOfInstitution(String nameInstitution,  PageRequest pageRequest);
}
