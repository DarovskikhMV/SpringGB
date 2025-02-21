package HW3.page;

import HW3.model.Employee;
import HW3.model.Project;
import HW3.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/home/projects")
public class ProjectPageController {

    private final ProjectService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getProjects(Model model) {
        model.addAttribute("projects", service.getProjects());
        return "projects-page";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Optional<Project> project = service.findById(id);
        Set<Employee> employees = service.findProjectEmployees(id);

        if (project.isPresent()) {
            model.addAttribute("project", project.get());
            model.addAttribute("employees", employees);
            return "project-page";
        }

        throw new NoSuchElementException("There is no project with id #" + id);
    }

}