package taskmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import taskmanagement.dao.entity.Task;
import taskmanagement.model.dto.TaskDto;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task toEntity(TaskDto taskDto);

    TaskDto toTaskDto(Task task);
}
