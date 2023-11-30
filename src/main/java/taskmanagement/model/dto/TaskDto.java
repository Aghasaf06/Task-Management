package taskmanagement.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import taskmanagement.dao.entity.Category;
import taskmanagement.model.enums.TaskPriority;
import taskmanagement.model.enums.TaskStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {

    String name;
    String description;
    TaskPriority priority;
    LocalDateTime deadline;
    TaskStatus status;
}
