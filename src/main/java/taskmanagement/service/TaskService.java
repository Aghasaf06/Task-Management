package taskmanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.entity.Category;
import taskmanagement.entity.Task;
import taskmanagement.model.TaskPriority;
import taskmanagement.model.TaskStatus;
import taskmanagement.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.getById(id);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public List<Task> getTasksByCategoryName(String categoryName) {
        return taskRepository.getTasksByCategoryName(categoryName);
    }

    public List<Task> getTasksByPriority(TaskPriority priority) {
        return taskRepository.getTasksByPriority(priority);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status);
    }
}
