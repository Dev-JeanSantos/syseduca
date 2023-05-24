package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.vos.CoursesOfInstitutionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT new com.fourtk.syseduca.vos.CoursesOfInstitutionVO (c.name, c.segment, c.status) FROM Institution i INNER JOIN  Course c  WHERE i.name LIKE '%nameInstitution%' ")
    List<CoursesOfInstitutionVO> getCoursesByInstitution(String nameInstitution);
}
