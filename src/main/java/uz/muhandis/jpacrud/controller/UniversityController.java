package uz.muhandis.jpacrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.jpacrud.entity.University;
import uz.muhandis.jpacrud.payload.UniversityDto;
import uz.muhandis.jpacrud.service.UniversityService;

import java.util.List;


@RestController
@RequestMapping( value = "/university")
public class UniversityController {
    private final UniversityService universityService;
    @Autowired
    public UniversityController(UniversityService universityService){
        this.universityService = universityService;
    }

    //Create
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUniversity(@RequestBody UniversityDto universityDto){
        return universityService.add(universityDto);
    }

    //Read
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public University getUniversity(@PathVariable Integer id){
        return universityService.get(id);
    }
    //Read all
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<University> getUniversitys(){
       return universityService.getAll();
    }

    //Update
    @PutMapping(value = "/{id}")
    public List<University> editUniversity(@PathVariable Integer id, @RequestBody UniversityDto universityDto){
        return universityService.update(id, universityDto);
    }

    //Delete
    @DeleteMapping(value = "/{id}")
    public List<University> deleteUniversity(@PathVariable Integer id){
        return universityService.delete(id);
    }

}
