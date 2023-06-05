package com.fourtk.syseduca.services;

import com.fourtk.syseduca.dto.requesties.DisciplineRequest;
import com.fourtk.syseduca.dto.responses.DisciplineResponse;
import com.fourtk.syseduca.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IDisciplineService {

    public DisciplineRequest insert(DisciplineRequest request);

    public Page<DisciplineResponse> findAllPaged(PageRequest pageRequest);

    public DisciplineResponse findById(Long id);

    public DisciplineRequest update(Long id, DisciplineRequest dto);

    public void updateStatus(Long id, Status status);

    public void delete(Long id);

}
