package taskmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import taskmanagement.dao.entity.Category;
import taskmanagement.model.dto.CategoryDto;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);
}
