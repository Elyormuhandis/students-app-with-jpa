package uz.muhandis.jpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.muhandis.jpacrud.entity.Address;

public interface AddresRepository extends JpaRepository<Address, Integer> {
}
