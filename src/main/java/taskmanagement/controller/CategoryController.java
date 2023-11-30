package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taskmanagement.dao.entity.Category;
import taskmanagement.model.dto.CategoryDto;
import taskmanagement.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(path = "/addCategory")
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }

    @GetMapping(path = "/getAllCategories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/getCategoryById")
    public CategoryDto getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping(path = "/updateCategory/{id}")
    public void updateCategory(@PathVariable Long id, @RequestParam String name) {
        categoryService.updateCategory(id, name);
    }

    @DeleteMapping(path = "/deleteCategoryById/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }

    @DeleteMapping(path = "/deleteAllCategories")
    public void deleteAllCategories() {
        categoryService.deleteAllCategories();
    }
}
