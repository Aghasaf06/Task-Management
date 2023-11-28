package taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskmanagement.entity.Task;
import taskmanagement.model.TaskPriority;
import taskmanagement.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getTasksByCategoryName(String categoryName);

    List<Task> getTasksByPriority(TaskPriority priority);

    List<Task> getTasksByStatus(TaskStatus status);
}
