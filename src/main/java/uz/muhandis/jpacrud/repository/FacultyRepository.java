package uz.muhandis.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.jpacrud.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
        boolean existsByNameAndUniversityId(String name, Integer universityId);

}
