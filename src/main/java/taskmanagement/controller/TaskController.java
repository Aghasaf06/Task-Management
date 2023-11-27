package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taskmanagement.entity.Task;
import taskmanagement.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
@RequiredArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping(path = "/addTask")
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @GetMapping(path = "/getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping(path = "/deleteTaskById/{id}")
    public void deleteTaskById(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @DeleteMapping(path = "/deleteAllTasks")
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }
}
