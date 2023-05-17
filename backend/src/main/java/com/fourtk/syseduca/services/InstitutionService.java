package com.fourtk.syseduca.services;

import com.fourtk.syseduca.controllers.InstitutionController;
import com.fourtk.syseduca.dto.requesties.InstitutionDTO;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class InstitutionService {

    Logger logger= Logger.getLogger(InstitutionController.class.getName());
    @Autowired
    private InstitutionRepository repository;

    public InstitutionDTO insert(InstitutionDTO request) {

        logger.info("Start insertInstitution - Service");
        Institution entity = new Institution();
        copyDtoToEntity(request, entity);
        entity = repository.save(entity);

        logger.info("Finalized insertInstitution - Service");
        return new InstitutionDTO(entity);
    }

    private void copyDtoToEntity(InstitutionDTO request, Institution entity) {
        entity.setName(request.getName());
        entity.setCnpj(request.getCnpj());
        entity.setStateRegistration(request.getStateRegistration());
        entity.setAddress(request.getAddress());
        entity.setPostalCode(request.getPostalCode());
        entity.setEmail(request.getEmail());
        entity.setCity(request.getCity());
        entity.setUf(request.getUf());
        entity.setComplement(request.getComplement());
        entity.setPhone(request.getPhone());
    }

    public Page<InstitutionDTO> findAllPaged(PageRequest pageRequest) {

        logger.info("Start GetAllInstitution - Service");
        Page<Institution> list = repository.findAll(pageRequest);
        logger.info("Finalized GetAllInstitution - Service");
        return  list.map(x -> new InstitutionDTO(x));
    }
}
