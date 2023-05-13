package com.fourtk.syseduca.controllers;

import com.fourtk.syseduca.dto.requesties.InstitutionDTO;
import com.fourtk.syseduca.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/institutions")
public class InstitutionController {
    @Autowired
    private InstitutionService service;

    @PostMapping
    public ResponseEntity<InstitutionDTO> insert(@RequestBody InstitutionDTO request){
        request = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }


}
