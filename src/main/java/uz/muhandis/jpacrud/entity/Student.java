package uz.muhandis.jpacrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String fullName;
    @OneToOne
    Address address;
    @ManyToOne
    Group group;
    @ManyToOne
    Faculty faculty;
    @ManyToMany
    List<Subject> subjects;
}
