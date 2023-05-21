package com.fourtk.syseduca.controllers;

import com.fourtk.syseduca.dto.requesties.CourseRequest;
import com.fourtk.syseduca.dto.responses.CourseResponse;
import com.fourtk.syseduca.services.CourseService;
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
@RequestMapping(value = "/courses")
public class CourseController {
    Logger logger= Logger.getLogger(CourseController.class.getName());
    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<CourseRequest> insert(@Valid @RequestBody CourseRequest request){
        logger.info("Start InsertCourse - Controller");
        request = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();

        logger.info("Finalized InsertCourse - Controller");
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy

    ){

        logger.info("Start GetAllCourse - Controller");
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<CourseResponse> list = service.findAllPaged(pageRequest);

        logger.info("Finalized GetAllCourse - Controller");
        return  ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseResponse>findById(@PathVariable Long id){
        logger.info("Start findById - Controller");

        CourseResponse dto = service.findById(id);

        logger.info("Finalized findById - Controller");
        return ResponseEntity.ok().body(dto);
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<CourseResponse> update(@PathVariable Long id,@Valid @RequestBody CourseRequest dto){
//
//        logger.info("Start update - Controller");
//
//        dto = service.update(id, dto);
//
//        logger.info("Finalized update - Controller");
//        return ResponseEntity.ok().body(dto);
//
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CourseResponse> delete(@PathVariable Long id){

        logger.info("Start delete - Controller");
        service.delete(id);
        logger.info("Finalized delete - Controller");

        return ResponseEntity.noContent().build();
    }

}
