package HW3.service;

import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.page.TimesheetPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimesheetPageService {

    private final TimesheetService timesheetService;
    private final ProjectService projectService;

    public List<TimesheetPageDto> findAll() {
        return timesheetService.getAll().stream()
                .map(this::convert)
                .toList();
    }

    public Optional<TimesheetPageDto> findById(Long id) {
        return timesheetService.getById(id) // Optional<Timesheet>
                .map(this::convert);
    }

    private TimesheetPageDto convert(Timesheet timesheet) {
        Project project = projectService.getById(timesheet.getProjectId())
                .orElseThrow();

        TimesheetPageDto timesheetPageParameters = new TimesheetPageDto();
        timesheetPageParameters.setProjectName(project.getName());
        timesheetPageParameters.setProjectId(String.valueOf(project.getId()));
        timesheetPageParameters.setId(String.valueOf(timesheet.getId()));
        // 150 -> 2h30m
        timesheetPageParameters.setMinutes(String.valueOf(timesheet.getMinutes()));
        timesheetPageParameters.setCreatedAt(timesheet.getCreatedAt().format(DateTimeFormatter.ISO_DATE));

        return timesheetPageParameters;
    }

}
