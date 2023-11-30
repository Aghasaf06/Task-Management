package taskmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import taskmanagement.dao.entity.Task;
import taskmanagement.model.dto.AddTaskDto;

@Mapper
public interface AddTaskMapper {

    AddTaskMapper INSTANCE = Mappers.getMapper(AddTaskMapper.class);

    Task toEntity(AddTaskDto addTaskDto);

    AddTaskDto toTaskDto(Task task);
}
