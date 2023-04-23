package uz.muhandis.jpacrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "groups")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "faculty_id"}))
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Faculty faculty;

    public Group(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
