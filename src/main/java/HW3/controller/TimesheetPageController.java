package HW3.controller;

import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetPageController {

    private final TimesheetService service;

    @GetMapping("/{id}")
    public String getTimesheetsPage(@PathVariable Long id, Model model)  {
        Optional<Timesheet> timesheetOpt = service.getById(id);

        if (timesheetOpt.isEmpty()) {
            // FIXME вернуть страницу not found
            //return not-found.html
            throw  new NoSuchElementException();
        }
        Timesheet timesheet = timesheetOpt.get();



        model.addAttribute("timesheetId", timesheet.getId());
        model.addAttribute("timesheetMinutes", timesheet.getMinutes());
        model.addAttribute("timesheetCreatedAt", timesheet.getCreatedAt().toString());
        return "timesheet-page.html";

    }

}
