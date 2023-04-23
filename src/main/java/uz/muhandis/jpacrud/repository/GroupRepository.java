package uz.muhandis.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.muhandis.jpacrud.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    //1-way
    List<Group> findAllByFaculty_UniversityIdOrderByName(Integer faculty_university_id);

//    //2-way with Jpa query
//    @Query("select gr from groups gr where groups.faculty.university.id=:universityId")
//    List<Group> findGroupsByUniversityId(Integer universityId);
//
//    //3-way with native SQL query
//    @Query(value = "SELECT * FROM groups g JOIN faculty f ON g.faculty_id=f.id " +
//            "join university u on u.id = f.university_id;", nativeQuery = true)
//    List<Group> findAllGroupsByUniversityIdNative(Integer universityId);


}
