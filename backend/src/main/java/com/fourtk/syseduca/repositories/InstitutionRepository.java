package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.models.Institution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Institution findByEmail(String email);
    Institution findByCnpj(String cnpj);

    Institution findByName(String nameInstitution);
}
