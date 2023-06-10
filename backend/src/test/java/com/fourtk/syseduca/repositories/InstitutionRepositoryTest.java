package com.fourtk.syseduca.repositories;

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

    @Test()
    void shouldSearchForAnInstitutionByEmail() {
        String email = "emiasmimgonzagaarantes@gmail.com";

        Institution institution = repository.findByEmail(email);

        Assertions.assertNotNull(institution);
        Assertions.assertEquals(email, institution.getEmail());
        Assertions.assertFalse(institution.getCourses().isEmpty());
    }
    @Test()
    void shouldSearchForAnInstitutionByCnpj() {
        String cnpj = "222222227/0001-25";

        Institution institution = repository.findByCnpj(cnpj);

        Assertions.assertNotNull(institution);
        Assertions.assertEquals(cnpj, institution.getCnpj());
        Assertions.assertFalse(institution.getCourses().isEmpty());
    }
    @Test()
    void shouldSearchForAnIdByName() {
        String name = "E M IASMIM GONZAGA ARANTES";

        Institution institution = repository.getIdbyName(name);

        Assertions.assertNotNull(institution);
        Assertions.assertEquals(name, institution.getName());
        Assertions.assertFalse(institution.getCourses().isEmpty());
    }


}
