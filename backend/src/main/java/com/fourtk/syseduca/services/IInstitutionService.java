package com.fourtk.syseduca.services;

import com.fourtk.syseduca.dto.requesties.InstitutionRequest;
import com.fourtk.syseduca.dto.responses.InstitutionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IInstitutionService {

    public InstitutionRequest insert(InstitutionRequest request);

    public Page<InstitutionResponse> findAllPaged(PageRequest pageRequest);

    public InstitutionRequest findById(Long id);

    public InstitutionRequest update(Long id, InstitutionRequest dto);

    public void delete(Long id);
}
