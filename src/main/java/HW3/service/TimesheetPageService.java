package HW3.service;

import HW3.model.Project;
import HW3.model.Timesheet;
import HW3.page.TimesheetPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

public interface TimesheetPageService {
    List<TimesheetPageDto> findAll();
    Optional<TimesheetPageDto> findById(Long id);
}