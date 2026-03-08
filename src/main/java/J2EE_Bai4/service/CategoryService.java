package J2EE_Bai4.service;

import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import J2EE_Bai4.models.Category;

@Service
public class CategoryService {
    private final List<Category> listCategory = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Stationary categories for temporary testing
        listCategory.add(new Category(1, "Stationery"));
        listCategory.add(new Category(2, "Office Supplies"));
        listCategory.add(new Category(3, "Writing Instruments"));
        listCategory.add(new Category(4, "Paper Products"));
        listCategory.add(new Category(5, "Art & Craft"));
    }

    public List<Category> getAll() {
        return Collections.unmodifiableList(listCategory);
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