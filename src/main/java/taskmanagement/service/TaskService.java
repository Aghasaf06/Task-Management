package taskmanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.dao.entity.Category;
import taskmanagement.dao.entity.Task;
import taskmanagement.mapper.TaskMapper;
import taskmanagement.model.dto.TaskDto;
import taskmanagement.model.enums.TaskPriority;
import taskmanagement.model.enums.TaskStatus;
import taskmanagement.dao.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final CategoryService categoryService;

    public void addTask(String categoryName, TaskDto taskDto) {
        Task task = TaskMapper.INSTANCE.toEntity(taskDto);
        Category category = categoryService.getCategoryByName(categoryName);
        task.setCategory(category);
        taskRepository.save(task);
    }

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream().map(TaskMapper.INSTANCE::toTaskDto)
                .collect(Collectors.toList());
    }

    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.getById(id);
        return TaskMapper.INSTANCE.toTaskDto(task);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public void updateTask(Long id, TaskDto taskDto) {
        taskRepository.updateTaskById(id, taskDto.getName(), taskDto.getDescription(), taskDto.getPriority(),
                taskDto.getDeadline(), taskDto.getStatus());
    }

    public List<TaskDto> getTasksByCategoryName(String categoryName) {
        return taskRepository.getTasksByCategoryName(categoryName)
                .stream().map(TaskMapper.INSTANCE::toTaskDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> getTasksByPriority(TaskPriority priority) {
        return taskRepository.getTasksByPriority(priority)
                .stream().map(TaskMapper.INSTANCE::toTaskDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> getTasksByStatus(TaskStatus status) {
        return taskRepository.getTasksByStatus(status)
                .stream().map(TaskMapper.INSTANCE::toTaskDto)
                .collect(Collectors.toList());
    }
}