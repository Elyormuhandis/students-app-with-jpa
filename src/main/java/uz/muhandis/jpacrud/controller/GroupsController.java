package uz.muhandis.jpacrud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.muhandis.jpacrud.entity.Group;
import uz.muhandis.jpacrud.payload.GroupDto;
import uz.muhandis.jpacrud.service.GroupsService;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupsController {
    final
    GroupsService groupsService;
    @Autowired
    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    //create

    @PostMapping("/add")
    public String createGroup(@RequestBody GroupDto groupDto){
        return groupsService.add(groupDto);
    }

    //read
    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Integer id){
        return groupsService.get(id);
    }

    //read by university id
    @GetMapping("/getByUniversityId/{universityId}")
    public List<Group> getByUniversityId(@PathVariable Integer universityId){
        return groupsService.getAllByUniversityId(universityId);
    }

    //read all
    @GetMapping("/all")
    public List<Group> getAllGroups(){
        return groupsService.getALl();
    }

//    update
    @PutMapping("/{id}")
    public List<Group> updateGroup(@PathVariable Integer id, @RequestBody GroupDto groupDto){
        return groupsService.update(id, groupDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public List<Group> deleteGroup(@PathVariable Integer id){
        return groupsService.delete(id);
    }


}
