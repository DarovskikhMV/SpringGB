package HW3.service;

import HW3.model.Timesheet;
import HW3.repository.TimesheetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimesheetService {
    Optional<Timesheet> findById(Long id);
    List<Timesheet> findAll();
    Timesheet create(Timesheet timesheet);
    void delete(Long id);
    List<Timesheet> getCreatedAfter(LocalDate date);
    List<Timesheet> getCreatedBefore(LocalDate date);
}