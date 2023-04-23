package uz.muhandis.jpacrud.service;

import org.springframework.stereotype.Service;
import uz.muhandis.jpacrud.entity.Faculty;
import uz.muhandis.jpacrud.entity.Group;
import uz.muhandis.jpacrud.payload.GroupDto;
import uz.muhandis.jpacrud.repository.FacultyRepository;
import uz.muhandis.jpacrud.repository.GroupRepository;
import uz.muhandis.jpacrud.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {
    private final GroupRepository groupRepository;
    private final UniversityRepository universityRepository;
    private final FacultyRepository facultyRepository;

    public GroupsService(GroupRepository groupRepository, UniversityRepository universityRepository, FacultyRepository facultyRepository) {
        this.groupRepository = groupRepository;
        this.universityRepository = universityRepository;
        this.facultyRepository = facultyRepository;
    }

    //create
    public String add(GroupDto groupDto) {
        Faculty faculty = facultyRepository.findById(groupDto.getFacultyId()).isPresent()
                ? facultyRepository.findById(groupDto.getFacultyId()).get() : null;
        if (faculty == null) return "Such faculty not found!";
        Group group = new Group(groupDto.getName(), faculty);
        groupRepository.save(group);
        return "Group successfully added!";
    }

    //read
    public Group get(Integer id) {
        return groupRepository.findById(id).isPresent() ? groupRepository.findById(id).get() : new Group();
    }

//    read all groups in university
    public List<Group> getAllByUniversityId(Integer universityId) {
        if (universityRepository.findById(universityId).isPresent()) {
            return groupRepository.findAllByFaculty_UniversityIdOrderByName(universityId);
        }
        return null;
    }

    //read all existing groups
    public List<Group> getALl() {
        return groupRepository.findAll();
    }

    //update
    public List<Group> update(Integer id, GroupDto groupDto) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDto.getFacultyId());
        if (optionalFaculty.isPresent() && optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            Faculty faculty = optionalFaculty.get();
            group.setName(groupDto.getName());
            faculty.setId(groupDto.getFacultyId());
            group.setFaculty(faculty);
            groupRepository.save(group);
            return groupRepository.findAll();
        }
        return null;
    }

    public List<Group> delete(Integer id) {
        if (groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
            return groupRepository.findAll();
        }
        return null;
    }

}
