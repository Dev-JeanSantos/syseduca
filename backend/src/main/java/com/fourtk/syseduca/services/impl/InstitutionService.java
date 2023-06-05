package com.fourtk.syseduca.services.impl;

import com.fourtk.syseduca.controllers.InstitutionController;
import com.fourtk.syseduca.dto.requesties.InstitutionRequest;
import com.fourtk.syseduca.dto.responses.InstitutionResponse;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import com.fourtk.syseduca.services.IInstitutionService;
import com.fourtk.syseduca.services.exceptions.DataBaseException;
import com.fourtk.syseduca.services.exceptions.ResourcesNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class InstitutionService implements IInstitutionService {

    Logger logger= Logger.getLogger(InstitutionController.class.getName());
    @Autowired
    private InstitutionRepository repository;

    @Transactional
    public InstitutionRequest insert(InstitutionRequest request) {

        logger.info("Start insertInstitution - Service");
        Institution entity = new Institution();
        copyDtoToEntity(request, entity);
        entity = repository.save(entity);

        logger.info("Finalized insertInstitution - Service");
        return new InstitutionRequest(entity);
    }

    @Transactional(readOnly = true)
    public Page<InstitutionResponse> findAllPaged(PageRequest pageRequest) {

        logger.info("Start GetAllInstitution - Service");
        Page<Institution> list = repository.findAll(pageRequest);
        logger.info("Finalized GetAllInstitution - Service");
        return  list.map(x -> new InstitutionResponse(x));
    }

    @Transactional
    public InstitutionRequest findById(Long id) {

        logger.info("Start FindById - Service");
        Optional<Institution> obj = repository.findById(id);

        Institution entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Institution Not Found"));

        logger.info("Finalized FindById - Service");
        return new InstitutionRequest(entity);
    }

    @Transactional
    public InstitutionRequest update(Long id, InstitutionRequest dto) {

        logger.info("Start Update - Service");
        try {
            Institution entity =  repository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity =  repository.save(entity);

        logger.info("Finalized Update - Service");
            return  new InstitutionRequest(entity);
        }catch (EntityNotFoundException e){
            throw new ResourcesNotFoundException(" Id Not Found "+ id);
        }
    }

    @Transactional
    @ExceptionHandler(ResourcesNotFoundException.class)
    public void delete(Long id) {
        try{
        logger.info("Start Delete - Service");

            repository.deleteById(id);

        logger.info("Finalized Delete - Service");
        }catch (ResourcesNotFoundException e){
            throw new ResourcesNotFoundException("ID Not Found "+ id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity Violation");
        }
    }

    private void copyDtoToEntity(InstitutionRequest request, Institution entity) {
        entity.setName(request.getName());
        entity.setCnpj(request.getCnpj());
        entity.setInep(request.getInep());
        entity.setAddress(request.getAddress());
        entity.setPostalCode(request.getPostalCode());
        entity.setEmail(request.getEmail());
        entity.setCity(request.getCity());
        entity.setUf(request.getUf());
        entity.setComplement(request.getComplement());
        entity.setPhone(request.getPhone());
    }
}
