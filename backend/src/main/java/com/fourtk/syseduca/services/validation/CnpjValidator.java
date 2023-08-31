package com.fourtk.syseduca.services.validation;

import com.fourtk.syseduca.config.FieldMessage;
import com.fourtk.syseduca.dto.requesties.InstitutionRequest;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class CnpjValidator implements ConstraintValidator<CnpjValid, InstitutionRequest> {

    @Autowired
    private InstitutionRepository repository;

    @Override
    public void initialize(CnpjValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(InstitutionRequest institutionRequest, ConstraintValidatorContext constraintValidatorContext) {

        List<FieldMessage> list = new ArrayList<>();

        Institution institution = repository.findByCnpj(institutionRequest.getCnpj());
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
