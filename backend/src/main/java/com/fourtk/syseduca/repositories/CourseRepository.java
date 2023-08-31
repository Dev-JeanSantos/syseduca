package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.dto.responses.CourseResponse;
import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.vos.CoursesOfInstitutionVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM tb_course WHERE institution_id = ?1", nativeQuery = true)
    Page<Course> searchCoursesByNameInstitution(Long id,  PageRequest pageRequest);
}
