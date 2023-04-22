package uz.muhandis.jpacrud.controller;

import org.springframework.web.bind.annotation.*;
import uz.muhandis.jpacrud.entity.Faculty;
import uz.muhandis.jpacrud.payload.FacultyDto;
import uz.muhandis.jpacrud.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    final
    FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    //create
    @PostMapping()
    public String addFaculty(@RequestBody FacultyDto f) {
        return facultyService.add(f);
    }
    //read
    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable Integer id) {
        return facultyService.get(id);
    }
    //read all
    @GetMapping("/all")
    public List<Faculty> getFaculty() {
        return facultyService.getAll();
    }

    //update
    @PutMapping("/{id}")
    public List<Faculty> updateFaculty(@PathVariable Integer id, @RequestBody FacultyDto facultyDto) {
        return facultyService.update(id, facultyDto);
    }
    //delete
    @DeleteMapping("/{id}")
    public List<Faculty> deleteFaculty(@PathVariable Integer id) {
        return facultyService.delete(id);
    }

}
