package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.models.Category;

@Service
public class CategoryService {
    private final List<Category> listCategory = new ArrayList<>();

    public List<Category> getAll() {
        return listCategory;
    }

    public Category get(int id) {
        return listCategory.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(Category newCategory) {
        int maxId = listCategory.stream().mapToInt(Category::getId).max().orElse(0);
        newCategory.setId(maxId + 1);
        listCategory.add(newCategory);
    }

    public void update(Category editCategory) {
        Category found = get(editCategory.getId());
        if (found != null) {
            found.setName(editCategory.getName());
        }
    }

    public void delete(int id) {
        listCategory.removeIf(c -> c.getId() == id);
    }
}