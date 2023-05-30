package com.fourtk.syseduca.services.validation;

import com.fourtk.syseduca.config.FieldMessage;
import com.fourtk.syseduca.dto.requesties.DisciplineRequest;
import com.fourtk.syseduca.dto.requesties.InstitutionRequest;
import com.fourtk.syseduca.models.Discipline;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.DisciplineRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class DisciplineCodeValidator implements ConstraintValidator<DisciplineCodeValid, DisciplineRequest> {

    @Autowired
    private DisciplineRepository repository;

    @Override
    public void initialize(DisciplineCodeValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(DisciplineRequest disciplineRequest, ConstraintValidatorContext constraintValidatorContext) {

        List<FieldMessage> list = new ArrayList<>();

        Discipline discipline = repository.findByDisciplineCode(disciplineRequest.getDisciplineCode());
        if (discipline != null) {
            list.add(new FieldMessage("DisciplineCode", "Discipline already exists"));
        }
        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
