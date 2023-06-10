package com.fourtk.syseduca.controllers;

import com.fourtk.syseduca.dto.requesties.DisciplineRequest;
import com.fourtk.syseduca.dto.requesties.DisciplineUpdateRequest;
import com.fourtk.syseduca.dto.responses.DisciplineResponse;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.services.impl.DisciplineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/disciplines")
public class DisciplineController {
    Logger logger = Logger.getLogger(DisciplineController.class.getName());
    @Autowired
    private DisciplineService service;

    @PostMapping
    public ResponseEntity<DisciplineRequest> insert(@Valid @RequestBody DisciplineRequest request) {
        logger.info("Start InsertDiscipline - Controller");
        System.out.println(request);
        request = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();

        logger.info("Finalized  InsertDiscipline - Controller");
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<Page<DisciplineResponse>> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy

    ){

        logger.info("Start GetAllCourse - Controller");
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<DisciplineResponse> list = service.findAllPaged(pageRequest);

        logger.info("Finalized GetAllCourse - Controller");
        return  ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DisciplineResponse>findById(@PathVariable Long id){
        logger.info("Start findById - Controller");

        DisciplineResponse dto = service.findById(id);

        logger.info("Finalized findById - Controller");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DisciplineUpdateRequest> update(@PathVariable Long id,@Valid @RequestBody DisciplineUpdateRequest dto){

        logger.info("Start update - Controller");

        dto = service.update(id, dto);

        logger.info("Finalized update - Controller");
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DisciplineResponse> delete(@PathVariable Long id){

        logger.info("Start delete - Controller");
        service.delete(id);
        logger.info("Finalized delete - Controller");

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeStatusActive(@PathVariable Long id){

        logger.info("Start change status  - Controller");
        service.updateStatus(id, Status.ACTIVE);
        logger.info("Finalized change status  - Controller");

    }
    @PutMapping(value = "/{id}/inactive")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeStatusInactive(@PathVariable Long id){

        logger.info("Start change status  - Controller");
        service.updateStatus(id, Status.INACTIVE);
        logger.info("Finalized change status  - Controller");

    }
    @PutMapping(value = "/{id}/finished")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeStatusFinish(@PathVariable Long id){

        logger.info("Start change status  - Controller");
        service.updateStatus(id, Status.FINISHED);
        logger.info("Finalized change status  - Controller");

    }
}

