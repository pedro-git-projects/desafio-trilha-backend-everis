package br.com.financas.controller;

import br.com.financas.dto.request.CategoryDTO;
import br.com.financas.model.Category;
import br.com.financas.service.CategoryService;
import br.com.financas.service.exceptions.ConstraintException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Collection<Category>> findAll() {
        Collection<Category> categories = categoryService.findAll();
        return  ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        Category _category = categoryService.findById(id);
        return ResponseEntity.ok().body(_category);
    }

    @PostMapping
    public  ResponseEntity<Category> insert(@Valid @RequestBody Category _category, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        _category = categoryService.insert(_category);
        return ResponseEntity.ok().body(_category);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@Valid @RequestBody Category _category, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        _category = categoryService.update(_category);
        return  ResponseEntity.ok().body(_category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/byTitle/{title}")
    public ResponseEntity<Collection<Category>> findByTitle(@PathVariable String title) {
        Collection<Category> categories = categoryService.findByTitle(title);
        return ResponseEntity.ok(categories);
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        categoryDTO.setId(category.getId());
        categoryDTO.setTitle(category.getTitle());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    private Category convertToEntity(CategoryDTO categoryDTO) throws ParseException {
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setId(categoryDTO.getId());
        category.setTitle(categoryDTO.getTitle());
        category.setDescription(categoryDTO.getDescription());

        if(categoryDTO.getId() != null) {
            Category oldCategory = categoryService.findById(categoryDTO.getId());
        }
        return category;

    }


}
