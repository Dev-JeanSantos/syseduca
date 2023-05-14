package com.fourtk.syseduca.services.validation;

import com.fourtk.syseduca.config.FieldMessage;
import com.fourtk.syseduca.dto.requesties.InstitutionDTO;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class CnpjValidator implements ConstraintValidator<CnpjValid, InstitutionDTO> {

    @Autowired
    private InstitutionRepository repository;

    @Override
    public void initialize(CnpjValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(InstitutionDTO institutionDTO, ConstraintValidatorContext constraintValidatorContext) {

        List<FieldMessage> list = new ArrayList<>();

        Institution institution = repository.findByCnpj(institutionDTO.getCnpj());
        if (institution != null) {
            list.add(new FieldMessage("Cnpj", "Cnpj already exists"));
        }
        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
