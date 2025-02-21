package HW3.service;

import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.repository.ProjectRepository;
import HW3.repository.TimesheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service // то же самое, что и Component
public class TimesheetServiceImpl implements TimesheetService {

    private final TimesheetRepository repository;
    private final ProjectRepository projectRepository;

    @Override
    public Optional<Timesheet> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Timesheet> findAll() {
        return repository.findAll();
    }

    @Override
    public Timesheet create(Timesheet timesheet) {
        Long projectId = timesheet.getProjectId();

        if (projectId == null) {
            throw new NullPointerException("There is no project id.");
        }

        Optional<Project> project = projectRepository.findById(timesheet.getProjectId());

        if (project.isPresent()) {
            timesheet.setCreatedAt(LocalDate.now());
            return repository.save(timesheet);
        }

        throw new NoSuchElementException("There is no project with id " + projectId + ".");
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Timesheet> getCreatedAfter(LocalDate date) {
        return repository.findAll().stream()
                .filter(timesheet -> timesheet.getCreatedAt().isAfter(ChronoLocalDate.from(date)))
                .toList();
    }

    @Override
    public List<Timesheet> getCreatedBefore(LocalDate date) {
        return repository.findAll().stream()
                .filter(timesheet -> timesheet.getCreatedAt().isBefore(ChronoLocalDate.from(date)))
                .toList();
    }
}
