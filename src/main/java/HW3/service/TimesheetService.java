package HW3.service;

import HW3.model.Timesheet;
import HW3.repository.TimesheetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service  //метка того что сервисный слой, тоже самое, что и Component
public class TimesheetService {
    private final TimesheetRepository repository;

    public TimesheetService(TimesheetRepository repository) {
        this.repository = repository;

    }

    public Optional<Timesheet> getById(Long id ) {
        return repository.getById(id);
    }

    public List<Timesheet> getAll() {
        return repository.getAll();
    }

    public Timesheet create(Timesheet timesheet) {
        return repository.create(timesheet);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
