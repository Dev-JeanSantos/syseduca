package com.fourtk.syseduca.services;

import com.fourtk.syseduca.controllers.CourseController;
import com.fourtk.syseduca.dto.requesties.CourseRequest;
import com.fourtk.syseduca.dto.requesties.DisciplineRequest;
import com.fourtk.syseduca.models.Course;
import com.fourtk.syseduca.models.Discipline;
import com.fourtk.syseduca.models.Institution;
import com.fourtk.syseduca.repositories.DisciplineRepository;
import com.fourtk.syseduca.repositories.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class DisciplineService {

    Logger logger= Logger.getLogger(CourseController.class.getName());
    @Autowired
    private DisciplineRepository repository;

    @Autowired
    private InstitutionRepository institutionRepository;


    @Transactional
    public DisciplineRequest insert(DisciplineRequest request) {

        logger.info("Start insertCourse - Service");
        Discipline entity = new Discipline();
        copyDtoToEntity(request, entity);
        entity = repository.save(entity);

        logger.info("Finalized insertCourse - Service");
        return new DisciplineRequest(entity);
    }

//    @Transactional(readOnly = true)
//    public Page<CourseResponse> findAllPaged(PageRequest pageRequest) {
//
//        logger.info("Start GetAllCourse - Service");
//        Page<Course> list = repository.findAll(pageRequest);
//        logger.info("Finalized GetAllCourse - Service");
//        return  list.map(x -> new CourseResponse(x));
//    }
//
//    @Transactional
//    public CourseResponse findById(Long id) {
//
//        logger.info("Start FindById - Service");
//        Optional<Course> obj = repository.findById(id);
//
//        Course entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Course Not Found"));
//
//        logger.info("Finalized FindById - Service");
//        return new CourseResponse(entity);
//    }
//
//    @Transactional
//    public CourseRequest update(Long id, CourseRequest dto) {
//
//        logger.info("Start Update - Service");
//        try {
//            Course entity =  repository.getOne(id);
//            copyUpdateToEntity(dto, entity);
//            entity =  repository.save(entity);
//
//        logger.info("Finalized Update - Service");
//            return  new CourseRequest(entity);
//        }catch (EntityNotFoundException e){
//            throw new ResourcesNotFoundException(" Id Not Found "+ id);
//        }
//    }
//
//    @Transactional
//    public void updateStatus(Long id, Status status) {
//
//        try {
//            Course entity = repository.getOne(id);
//            entity.setStatus(status);
//            repository.save(entity);
//        } catch (ResourcesNotFoundException e) {
//            throw new ResourcesNotFoundException("ID Not Found " + id);
//        }
//    }
//
//    @Transactional
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

    private void copyDtoToEntity(DisciplineRequest request, Discipline entity) {
        entity.setName(request.getName());
        entity.setPeriodicity(request.getPeriodicity());
        entity.setId(request.getId());
        entity.setWorkload(request.getWorkload());
        entity.setDisciplineCode(request.getDisciplineCode());
        entity.setStatus(request.getStatus());
        entity.setPeriod(request.getPeriod());
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

//    public List<CoursesOfInstitutionVO> findByName(String nameInstitution) {
////        Institution institution = institutionRepository.findByName(nameInstitution);
//
//        return repository.getCoursesByInstitution(nameInstitution);
//
//
//    }
}
