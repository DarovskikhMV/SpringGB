package HW3.service;

import HW3.model.Project;
import HW3.page.ProjectPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectPageService {
    private final TimesheetService timesheetService;
    private final ProjectService projectService;
    public List<ProjectPageDto> findAll() {
        return projectService.getAll().stream().map(this::convert).toList();
    }

    public Optional<ProjectPageDto> findById(Long id) {
        return projectService.getById(id).map(this::convert);
    }

    public ProjectPageDto convert(Project project){
        ProjectPageDto projectPageParameters = new ProjectPageDto();
        projectPageParameters.setId(String.valueOf(project.getId()));
        projectPageParameters.setName(project.getName());

//        projectPageParameters.setTimesheets(timesheetRepository.getTimesheetsByProjectId(project.getId()));

        return projectPageParameters;
    }
}
