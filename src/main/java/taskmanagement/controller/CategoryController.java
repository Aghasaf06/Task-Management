package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import taskmanagement.entity.Category;
import taskmanagement.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(path = "/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @GetMapping(path = "/getAllCategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/getCategoryById")
    public Category getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
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
