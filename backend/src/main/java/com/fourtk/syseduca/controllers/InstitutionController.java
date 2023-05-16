package com.fourtk.syseduca.controllers;

import com.fourtk.syseduca.dto.requesties.InstitutionDTO;
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
import java.util.List;

@RestController
@RequestMapping(value = "/institutions")
public class InstitutionController {
    @Autowired
    private InstitutionService service;

    @PostMapping
    public ResponseEntity<InstitutionDTO> insert(@Valid @RequestBody InstitutionDTO request){
        request = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<Page<InstitutionDTO>> getAll(
            @RequestParam(value = "institutionId", defaultValue = "0") Long institutionId,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy

    ){

        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<InstitutionDTO> list = service.findAllPaged(name.trim(), institutionId, pageRequest);

        return  ResponseEntity.ok().body(list);

    }


}
