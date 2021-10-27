package trilha.back.finances.controller;


import org.springframework.web.bind.annotation.*;
import trilha.back.finances.models.Category;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {



    @PostMapping
    public Category postCategory(@RequestBody Category category) {
        return category;
    }

    @GetMapping
    public List getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Informatica", "Itens de informática", 1337));
        categoryList.add(new Category("Saúde", "Itens médicos", 4521));
        return categoryList;
    }

}
