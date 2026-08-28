package com.filipeleal.springbootaprendizado;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        Category category = categoryService.createCategory(name);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> categories = categoryService.listCategories();
        
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> listCategoryById(@PathVariable long id) {
        Category category = categoryService.getCategoryById(id);

        if (category != null) {
            return ResponseEntity.ok(category);
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> renameCategoryById(@PathVariable long id, @RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        Category category = categoryService.renameCategory(id, name);

        if (category != null) {
            return ResponseEntity.ok(category);
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable long id) {
        boolean category = categoryService.deleteCategory(id);

        if (category) {
            return ResponseEntity.ok("Deleted category with ID " + id);
        }

        return ResponseEntity.notFound().build();
    }
}
