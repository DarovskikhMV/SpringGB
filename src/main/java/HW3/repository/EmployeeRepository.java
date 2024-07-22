package HW3.repository;

import HW3.model.Employee;
import HW3.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select p from Project p")
    Set<Project> findAllProjects(Employee employee);
}