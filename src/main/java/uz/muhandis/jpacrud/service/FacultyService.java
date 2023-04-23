package uz.muhandis.jpacrud.service;

import org.springframework.stereotype.Service;
import uz.muhandis.jpacrud.entity.Faculty;
import uz.muhandis.jpacrud.entity.University;
import uz.muhandis.jpacrud.payload.FacultyDto;
import uz.muhandis.jpacrud.repository.FacultyRepository;
import uz.muhandis.jpacrud.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    final
    FacultyRepository facultyRepository;
    final
    UniversityRepository universityRepository;


    public FacultyService(FacultyRepository facultyRepository, UniversityRepository universityRepository) {
        this.facultyRepository = facultyRepository;
        this.universityRepository = universityRepository;
    }


    //Create
    public String add(FacultyDto facultyDto) {
        Optional<University> universityOptional = universityRepository.findById(facultyDto.getUniversityId());
        University university = universityOptional.isPresent() ? universityOptional.get()
                : null;
        if (university == null) return "Such university not found";
        if (facultyRepository.existsByNameAndUniversityId(facultyDto.getName(), facultyDto.getUniversityId()))
            return "Such faculty already exist!";
        Faculty faculty = new Faculty(facultyDto.getName(), university);
        facultyRepository.save(faculty);
        return "Faculty successfully added!";
    }

    public Faculty get(Integer id) {
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        return facultyOptional.isPresent() ? facultyOptional.get() : null;
    }

    public List<Faculty> getByUniversity(Integer universityId){
        if (!universityRepository.findById(universityId).isPresent()) return null;
        return facultyRepository.findFacultyByUniversityId(universityId);
    }

    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public List<Faculty> update(Integer id, FacultyDto facultyDto) {
        Optional<Faculty> facultyOptional = facultyRepository.findById(id);
        Faculty faculty = facultyOptional.isPresent() ? facultyOptional.get() : null;
        if (faculty != null) {
            University university = faculty.getUniversity();
            university.setId(facultyDto.getUniversityId());
            faculty.setName(facultyDto.getName());
            faculty.setUniversity(university);
            facultyRepository.save(faculty);
            return facultyRepository.findAll();
        }
        return null;
    }

    public List<Faculty> delete(Integer id) {
        if (!facultyRepository.existsById(id)) return null;
        facultyRepository.deleteById(id);
        return facultyRepository.findAll();
    }
}
