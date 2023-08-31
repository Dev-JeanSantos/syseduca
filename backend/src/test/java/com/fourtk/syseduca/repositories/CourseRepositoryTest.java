package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Institution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private InstitutionRepository institutionRepository;

    private PageRequest pageRequest;

    @BeforeEach
    void setUp() throws Exception{
        pageRequest = PageRequest.of(0, 10);
    }

    @Test()
    void shouldSearchCoursesByNameInstitution() {
        String nameInstitution = "E M IASMIM GONZAGA ARANTES";

        Institution institution = institutionRepository.getIdbyName(nameInstitution);

        Page<Course> course = courseRepository.searchCoursesByNameInstitution(institution.getId(), pageRequest);

        Assertions.assertNotNull(institution);
        Assertions.assertNotNull(course);
        Assertions.assertEquals(nameInstitution, institution.getName());
        Assertions.assertFalse(institution.getCourses().isEmpty());

    }
}

