package HW3.service;

import HW3.model.Employee;
import HW3.model.Project;
import HW3.model.Timesheet;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee create(Employee employee);
    void deleteById(Long id);
    Optional<Employee> update(Long id, Employee employee);
    List<Timesheet> findByEmployeeId(Long id);
    Set<Project> findEmployeeProjects(Long id);
}