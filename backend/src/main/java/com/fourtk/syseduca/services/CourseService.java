package com.fourtk.syseduca.services;

import com.fourtk.syseduca.controllers.CourseController;
import com.fourtk.syseduca.dto.requesties.CourseRequest;
import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.CourseRepository;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class CourseService {

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
        return new CourseRequest(entity);
    }

//    @Transactional(readOnly = true)
//    public Page<CourseDTO> findAllPaged(PageRequest pageRequest) {
//
//        logger.info("Start GetAllCourse - Service");
//        Page<Course> list = repository.findAll(pageRequest);
//        logger.info("Finalized GetAllCourse - Service");
//        return  list.map(x -> new CourseDTO(x));
//    }
//
//    @Transactional
//    public CourseDTO findById(Long id) {
//
//        logger.info("Start FindById - Service");
//        Optional<Course> obj = repository.findById(id);
//
//        Course entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Course Not Found"));
//
//        logger.info("Finalized FindById - Service");
//        return new CourseDTO(entity);
//    }
//
//    @Transactional
//    public CourseDTO update(Long id, CourseDTO dto) {
//
//        logger.info("Start Update - Service");
//        try {
//            Course entity =  repository.getOne(id);
//            copyDtoToEntity(dto, entity);
//            entity =  repository.save(entity);
//
//        logger.info("Finalized Update - Service");
//            return  new CourseDTO(entity);
//        }catch (EntityNotFoundException e){
//            throw new ResourcesNotFoundException(" Id Not Found "+ id);
//        }
//    }
//
//    @Transactional
//    @ExceptionHandler(ResourcesNotFoundException.class)
//    public void delete(Long id) {
//        try{
//        logger.info("Start Delete - Service");
//
//            repository.deleteById(id);
//
//        logger.info("Finalized Delete - Service");
//        }catch (ResourcesNotFoundException e){
//            throw new ResourcesNotFoundException("ID Not Found "+ id);
//        }catch (DataIntegrityViolationException e){
//            throw new DataBaseException("Integrity Violation");
//        }
//    }

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
}