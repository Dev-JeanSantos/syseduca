package com.fourtk.syseduca.repositories;

import com.fourtk.syseduca.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findByDisciplineCode(Integer disciplineCode);
}
