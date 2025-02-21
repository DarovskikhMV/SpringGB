package HW3.repository;

import HW3.model.Timesheet;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface TimesheetNeededRepository <T, ID> extends Repository<T, ID> {
    List<T> findAll();
    List<Timesheet> findByProjectId(ID id);
    List<Timesheet> findByEmployeeId(ID id);
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id);
}
