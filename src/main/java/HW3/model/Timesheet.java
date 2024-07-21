package HW3.model;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Timesheet {
    private Long id;
    private Long projectId;
    private int minutes;
    private LocalDate createdAt;
}
