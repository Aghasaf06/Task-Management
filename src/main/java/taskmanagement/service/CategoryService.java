package taskmanagement.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import taskmanagement.dao.entity.Category;
import taskmanagement.dao.repository.CategoryRepository;
import taskmanagement.mapper.CategoryMapper;
import taskmanagement.mapper.TaskMapper;
import taskmanagement.model.dto.CategoryDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void addCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        categoryRepository.save(category);
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(CategoryMapper.INSTANCE::toCategoryDto)
                .collect(Collectors.toList());
    }

    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.getById(id);
        return CategoryMapper.INSTANCE.toCategoryDto(category);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    public void updateCategory(Long id, String name) {
        categoryRepository.updateCategoryById(id, name);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }
}
