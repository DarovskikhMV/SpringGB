package HW3.repository;

import HW3.model.Timesheet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import java.util.List;

//@Repository // @Component для классов, работающих с данными
//public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
//    List<Timesheet> findByProjectId(Long id);
//}
@Repository // @Component для классов, работающих с данными
public interface TimesheetRepository extends TimesheetNeededRepository<Timesheet, Long> {
}
