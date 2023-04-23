package uz.muhandis.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.jpacrud.entity.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
        boolean existsByNameAndUniversityId(String name, Integer universityId);
        List<Faculty> findFacultyByUniversityId(Integer university_id);
}
