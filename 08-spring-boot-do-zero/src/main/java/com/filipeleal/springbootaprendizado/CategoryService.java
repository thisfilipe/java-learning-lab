package com.filipeleal.springbootaprendizado;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String name) {
        Category category = new Category(name);

        return categoryRepository.save(category);
    }

    public Category renameCategory(long id, String name) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.orElse(null);

        if (category != null) {
            category.rename(name);
            return categoryRepository.save(category);
        }

        return null;
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public boolean deleteCategory(long id) {
        boolean category = categoryRepository.existsById(id);

        if (category) {
            categoryRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
