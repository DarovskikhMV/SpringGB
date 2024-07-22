package HW3.service;

import HW3.model.Employee;
import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.repository.EmployeeRepository;
import HW3.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final TimesheetRepository timesheetRepository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Employee> update(Long id, Employee employee) {
        Optional<Employee> needUpdate = findById(id);

        if (needUpdate.isPresent()) {
            employee.setId(id);
            repository.save(employee);
            return Optional.of(employee);
        }

        return Optional.empty();
    }

    @Override
    public List<Timesheet> findByEmployeeId(Long id) {
        return timesheetRepository.findByEmployeeId(id);
    }

    @Override
    public Set<Project> findEmployeeProjects(Long id) {
        Optional<Employee> employee = findById(id);

        if (employee.isPresent()) {
            return Collections.singleton((Project) repository.findAllProjects(employee.get()));
        }

        return Collections.emptySet();
    }

}
