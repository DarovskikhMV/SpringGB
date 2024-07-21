package HW3.page;

import lombok.Data;

@Data
public class TimesheetPageDto {

    private String id;
    private String projectName;
    private String projectId;
    private String minutes;
    private String createdAt;

}
