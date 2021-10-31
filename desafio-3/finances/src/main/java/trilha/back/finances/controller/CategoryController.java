package trilha.back.finances.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import trilha.back.finances.models.Category;

import java.util.ArrayList;
import java.util.List;

@Api (tags = "category")
@RestController
@RequestMapping("/category")
public class CategoryController {


    @ApiOperation(value = "Post category")
    @PostMapping
    public Category postCategory(@RequestBody Category category) {
        return category;
    }

    @ApiOperation(value = "Get category")
    @GetMapping
    public List getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Informatica", "Itens de informática", 1337));
        categoryList.add(new Category("Saúde", "Itens médicos", 4521));
        return categoryList;
    }

}
