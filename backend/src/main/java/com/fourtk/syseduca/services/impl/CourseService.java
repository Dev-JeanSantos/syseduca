package com.fourtk.syseduca.services.impl;

import com.fourtk.syseduca.controllers.CourseController;
import com.fourtk.syseduca.dto.requesties.CourseRequest;
import com.fourtk.syseduca.dto.responses.CourseDisciplineResponse;
import com.fourtk.syseduca.dto.responses.CourseResponse;
import com.fourtk.syseduca.enums.Status;
import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.CourseRepository;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import com.fourtk.syseduca.services.ICourseService;
import com.fourtk.syseduca.services.exceptions.DataBaseException;
import com.fourtk.syseduca.services.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CourseService implements ICourseService {

    Logger logger= Logger.getLogger(CourseController.class.getName());
    @Autowired
    private CourseRepository repository;

    @Autowired
    private InstitutionRepository institutionRepository;


    @Transactional
    public CourseRequest insert(CourseRequest request) {

        logger.info("Start insertCourse - Service");
        Course entity = new Course();
        copyDtoToEntity(request, entity);
        entity = repository.save(entity);

        logger.info("Finalized insertCourse - Service");
        return CourseRequest.converterRequest(entity);
    }

    @Transactional(readOnly = true)
    public Page<CourseResponse> findAllPaged(PageRequest pageRequest) {

        logger.info("Start GetAllCourse - Service");
        Page<Course> list = repository.findAll(pageRequest);
        logger.info("Finalized GetAllCourse - Service");
        return  list.map(CourseResponse::converterCourseResponse);
    }

    @Transactional(readOnly = true)
    public Page<CourseResponse> coursesOfInstitution(String nameInstitution, PageRequest pageRequest) {

        try{
            String institutionUperCase = nameInstitution.toUpperCase();
            Institution institution = institutionRepository.getIdbyName(institutionUperCase);
            Page<Course> courses = repository.searchCoursesByNameInstitution(institution.getId(), pageRequest);
            return courses.map(CourseResponse::converterCourseResponse);
        }catch (NullPointerException e){
            throw new NullPointerException("Institution id not found!");
        }catch (NonUniqueResultException e){
            throw new NonUniqueResultException("Refine your search!");
        }
    }

    @Transactional
    public CourseDisciplineResponse findById(Long id) {

        logger.info("Start FindById - Service");
        Optional<Course> obj = repository.findById(id);

        Course entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Course Not Found"));

        logger.info("Finalized FindById - Service");
        return CourseDisciplineResponse.converterCourseResponse(entity);
    }

    @Transactional
    public CourseRequest update(Long id, CourseRequest dto) {

        logger.info("Start Update - Service");
        try {
            Course entity =  repository.getOne(id);
            copyUpdateToEntity(dto, entity);
            entity =  repository.save(entity);

        logger.info("Finalized Update - Service");
            return  CourseRequest.converterRequest(entity);
        }catch (EntityNotFoundException e){
            throw new ResourcesNotFoundException(" Id Not Found "+ id);
        }
    }

    @Transactional
    public void updateStatus(Long id, Status status) {

        try {
            Course entity = repository.getOne(id);
            entity.setStatus(status);
            repository.save(entity);
        } catch (ResourcesNotFoundException e) {
            throw new ResourcesNotFoundException("ID Not Found " + id);
        }
    }

    @Transactional
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

    private void copyDtoToEntity(CourseRequest request, Course entity) {
        entity.setName(request.getName());
        entity.setDuration(request.getDuration());
        entity.setPeriodicity(request.getPeriodicity());
        entity.setId(request.getId());
        entity.setSegment(request.getSegment());
        entity.setStatus(request.getStatus());
        Institution institution = institutionRepository.getOne(request.getIdInstitution());
        entity.setInstitution(institution);
    }
    private void copyUpdateToEntity(CourseRequest request, Course entity) {
        Institution institution = institutionRepository.getOne(request.getIdInstitution());
        entity.setInstitution(institution);

        entity.setName(request.getName());
        entity.setDuration(request.getDuration());
        entity.setPeriodicity(request.getPeriodicity());
        entity.setStatus(request.getStatus());
        entity.setSegment(request.getSegment());
    }
}

