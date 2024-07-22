package HW3.page;
import HW3.model.Employee;
import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.util.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/home/employees")
public class EmployeePageController {

    private final EmployeeService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getEmployees(Model model) {
        model.addAttribute("employees", service.findAll());
        return "employees-page";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Optional<Employee> employee = service.findById(id);
        List<Timesheet> timesheets = service.findByEmployeeId(id);
        Set<Project> projects = service.findEmployeeProjects(id);

        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            model.addAttribute("timesheets", timesheets);
            model.addAttribute("projects", projects);
            return "employee-page";
        }

        throw new NoSuchElementException("There is no employee with id #" + id);
    }

}