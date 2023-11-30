package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import taskmanagement.model.dto.TaskDto;
import taskmanagement.model.enums.TaskPriority;
import taskmanagement.model.enums.TaskStatus;
import taskmanagement.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping(path = "/addTask")
    @Transactional
    public void addTask(@RequestParam String categoryName, @RequestBody TaskDto taskDto) {
        taskService.addTask(categoryName, taskDto);
    }

    @GetMapping(path = "/getAllTasks")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/getTaskById")
    public TaskDto getTaskById(Long id) {
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

    @PostMapping(path = "/updateTask/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        taskService.updateTask(id, taskDto);
    }

    @GetMapping(path = "/getTasksByCategoryName")
    public List<TaskDto> getTasksByCategoryName(String name) {
        return taskService.getTasksByCategoryName(name);
    }

    @GetMapping(path = "/getTasksByPriority")
    public List<TaskDto> getTasksByPriority(TaskPriority priority) {
        return taskService.getTasksByPriority(priority);
    }

    @GetMapping(path = "/getTasksByStatus")
    public List<TaskDto> getTasksByStatus(TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }
}
