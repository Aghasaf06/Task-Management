package taskmanagement.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import taskmanagement.dao.entity.Task;
import taskmanagement.dao.entity.Category;
import taskmanagement.model.enums.TaskPriority;
import taskmanagement.model.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query("update Task set name = :name, description = :description, priority = :priority, deadline = :deadline, status = :status where id = :id")
    void updateTaskById(@Param("id") Long id, @Param("name") String name,
                        @Param("description") String description,
                        @Param("priority") TaskPriority priority,
                        @Param("deadline") LocalDateTime deadline,
                        @Param("status") TaskStatus status);

    List<Task> getTasksByCategoryName(String categoryName);

    List<Task> getTasksByPriority(TaskPriority priority);

    List<Task> getTasksByStatus(TaskStatus status);
}
