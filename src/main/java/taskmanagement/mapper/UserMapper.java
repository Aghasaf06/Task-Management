package taskmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import taskmanagement.dao.entity.User;
import taskmanagement.model.request.UserCreateRequest;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE  = Mappers.getMapper(UserMapper.class);

    User userCreateRequesttoUser(UserCreateRequest userCreateRequest);

}
