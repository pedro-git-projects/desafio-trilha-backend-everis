package br.com.financas.controller;


import br.com.financas.model.Category;
import br.com.financas.service.CategoryService;
import br.com.financas.service.excepctions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<Collection<Category>> findAll() {
        Collection<Category> categories = service.findAll();
        return  ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        Category _category = service.findById(id);
        return ResponseEntity.ok().body(_category);
    }

    @PostMapping
    public  ResponseEntity<Category> post(@Valid @RequestBody Category _category, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        _category = service.insert(_category);
        return ResponseEntity.ok().body(_category);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@Valid @RequestBody Category _category, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        _category = service.update(_category);
        return  ResponseEntity.ok().body(_category);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/byTitle/{title}")
    public ResponseEntity<Collection<Category>> findByTitle(@PathVariable String title) {
        Collection<Category> categories = service.findByTitle(title);
        return ResponseEntity.ok(categories);
    }
}
