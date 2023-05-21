package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}
