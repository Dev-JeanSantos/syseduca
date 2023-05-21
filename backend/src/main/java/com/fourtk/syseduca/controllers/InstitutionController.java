package com.fourtk.syseduca.controllers;

import com.fourtk.syseduca.dto.requesties.InstitutionRequest;
import com.fourtk.syseduca.dto.responses.InstitutionResponse;
import com.fourtk.syseduca.services.InstitutionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/institutions")
public class InstitutionController {
    Logger logger= Logger.getLogger(InstitutionController.class.getName());
    @Autowired
    private InstitutionService service;

    @PostMapping
    public ResponseEntity<InstitutionRequest> insert(@Valid @RequestBody InstitutionRequest request){
        logger.info("Start InsertInstitution - Controller");
        request = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();

        logger.info("Finalized InsertInstitution - Controller");
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<Page<InstitutionResponse>> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy

    ){

        logger.info("Start GetAllInstitution - Controller");
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<InstitutionResponse> list = service.findAllPaged(pageRequest);

        logger.info("Finalized GetAllInstitution - Controller");
        return  ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InstitutionRequest>findById(@PathVariable Long id){
        logger.info("Start findById - Controller");

        InstitutionRequest dto = service.findById(id);

        logger.info("Finalized findById - Controller");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InstitutionRequest> update(@PathVariable Long id, @Valid @RequestBody InstitutionRequest dto){

        logger.info("Start update - Controller");

        dto = service.update(id, dto);

        logger.info("Finalized update - Controller");
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<InstitutionRequest> delete(@PathVariable Long id){

        logger.info("Start delete - Controller");
        service.delete(id);
        logger.info("Finalized delete - Controller");

        return ResponseEntity.noContent().build();
    }

}
