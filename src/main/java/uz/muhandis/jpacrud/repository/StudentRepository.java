package uz.muhandis.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.jpacrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
