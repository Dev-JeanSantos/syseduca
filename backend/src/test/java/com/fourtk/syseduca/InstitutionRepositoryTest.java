package com.fourtk.syseduca;

import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InstitutionRepositoryTest {

    @Autowired
    private InstitutionRepository repository;


    @Test
    void shouldCreateInstitution(){
//        Institution institutionMock = Institution()
    }

    @Test()
    void shouldSearchForAnInstitutionByEmail() {
        String email = "emiasmimgonzagaarantes@gmail.com";

        Institution institution = repository.findByEmail(email);
        Assertions.assertNotNull(institution);
        Assertions.assertEquals(email, institution.getEmail());
        Assertions.assertFalse(institution.getCourses().isEmpty());
    }


}
