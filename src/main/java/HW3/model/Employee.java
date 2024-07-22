package HW3.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @ToString.Exclude
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "employee_project",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    private Set<Project> employeeProjects;

}
