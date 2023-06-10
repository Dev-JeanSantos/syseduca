package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.models.Institution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    Institution findByEmail(String email);
    Institution findByCnpj(String cnpj);
    @Query(value="SELECT * FROM tb_institution i WHERE i.name LIKE %?1%", nativeQuery=true)
    Institution getIdbyName(String nameInstitution);
}
