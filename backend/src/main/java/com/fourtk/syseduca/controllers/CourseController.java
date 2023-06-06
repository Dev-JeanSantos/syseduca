package com.fourtk.syseduca.controllers;

import com.fourtk.syseduca.dto.requesties.CourseRequest;
import com.fourtk.syseduca.dto.responses.CourseResponse;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.services.impl.CourseService;
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

    @GetMapping(value = "/reports")
    public ResponseEntity<Page<CourseResponse>> coursesOfInstitution(
            @RequestParam(value = "nameInstitution", defaultValue = "") String nameInstitution,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "20") Integer linePerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
    ){
        PageRequest pageRequest = PageRequest.of(page, linePerPage, Sort.Direction.valueOf(direction), orderBy);
        logger.info("Start coursesOfInstitution - Controller");
        System.out.println(nameInstitution);
        Page<CourseResponse> lists = service.coursesOfInstitution(nameInstitution, pageRequest);
        logger.info("Finalized coursesOfInstitution - Controller");

        return ResponseEntity.ok().body(lists);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseResponse>findById(@PathVariable Long id){
        logger.info("Start findById - Controller");

        CourseResponse dto = service.findById(id);

        logger.info("Finalized findById - Controller");
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CourseRequest> update(@PathVariable Long id,@Valid @RequestBody CourseRequest dto){

        logger.info("Start update - Controller");

        dto = service.update(id, dto);

        logger.info("Finalized update - Controller");
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CourseResponse> delete(@PathVariable Long id){

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

