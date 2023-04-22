package uz.muhandis.jpacrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.muhandis.jpacrud.entity.Address;
import uz.muhandis.jpacrud.entity.University;
import uz.muhandis.jpacrud.payload.UniversityDto;
import uz.muhandis.jpacrud.repository.AddresRepository;
import uz.muhandis.jpacrud.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddresRepository addresRepository;

    //Create
    public String add(UniversityDto universityDto) {
        Address address = new Address();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        Address savedAddress = addresRepository.save(address);
        University university = new University();
        university.setName(universityDto.getName());
        university.setAddress(savedAddress);
        universityRepository.save(university);
        return "University successfully saved!";
    }

    //Read
    public University get(Integer id) {
        Optional<University> university = universityRepository.findById(id);
        return university.get();
    }

    //Read all
    public List<University> getAll() {
        return universityRepository.findAll();
    }

    //Update
    public List<University> update(Integer id, UniversityDto universityDto) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        University university = optionalUniversity.isPresent()
                ? optionalUniversity.get() : null;
        if (university != null) {
            university.setName(universityDto.getName());
            Address address = university.getAddress();
            address.setCity(universityDto.getCity());
            address.setDistrict(universityDto.getDistrict());
            address.setStreet(universityDto.getStreet());
            universityRepository.save(university);
            return universityRepository.findAll();
        }
        return null;
    }

    //Delete
    public List<University> delete(Integer id){
        universityRepository.deleteById(id);
        return universityRepository.findAll();
    }
}
