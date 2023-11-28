package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import taskmanagement.entity.Category;
import taskmanagement.entity.Task;
import taskmanagement.model.TaskPriority;
import taskmanagement.model.TaskStatus;
import taskmanagement.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "/addTask")
    @Transactional
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @GetMapping(path = "/getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/getTaskById")
    public Task getTaskById(Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping(path = "/deleteTaskById/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

    @DeleteMapping(path = "/deleteAllTasks")
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }

    @GetMapping(path = "/getTasksByCategoryName")
    public List<Task> getTasksByCategoryName(String name) {
        return taskService.getTasksByCategoryName(name);
    }

    @GetMapping(path = "/getTasksByPriority")
    public List<Task> getTasksByPriority(TaskPriority priority) {
        return taskService.getTasksByPriority(priority);
    }

    @GetMapping(path = "/getTasksByStatus")
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }
}
