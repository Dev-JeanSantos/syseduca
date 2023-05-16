package com.fourtk.syseduca.services;

import com.fourtk.syseduca.dto.requesties.InstitutionDTO;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository repository;

    public InstitutionDTO insert(InstitutionDTO request) {
        Institution entity = new Institution();
        copyDtoToEntity(request, entity);
        entity = repository.save(entity);

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

    public Page<InstitutionDTO> findAllPaged(String name, Long institutionId, PageRequest pageRequest) {

//        List<Institution> institutions = (institutionId == 0) ? null : Arrays.asList(repository.getOne(institutionId));

        Page<Institution> list = repository.findAll(pageRequest);

        return  list.map(x -> new InstitutionDTO(x));
    }
}
