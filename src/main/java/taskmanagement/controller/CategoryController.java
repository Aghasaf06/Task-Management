package taskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import taskmanagement.entity.Category;
import taskmanagement.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
@RequiredArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping(path = "/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @GetMapping(path = "/getAllCategories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping(path = "/deleteCategoryById/{id}")
    public void deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
    }

    @DeleteMapping(path = "/deleteAllCategories")
    public void deleteAllCategories() {
        categoryService.deleteAllCategories();
    }
}
