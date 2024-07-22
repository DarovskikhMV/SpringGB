package HW3.service;

import HW3.model.Employee;
import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.repository.ProjectRepository;
import HW3.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectService {
    List<Project> getProjects();
    Optional<Project> findById(Long id);
    Project create(Project project);
    void deleteById(Long id);
    List<Timesheet> getProjectTimesheets(Long id);
    Optional<Project> update(Long id, Project project);
    Set<Employee> findProjectEmployees(Long id);
}