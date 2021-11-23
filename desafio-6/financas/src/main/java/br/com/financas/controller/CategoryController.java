package br.com.financas.controller;

import br.com.financas.dto.category.CategoryRequestDTO;
import br.com.financas.dto.category.CategoryResponseDTO;
import br.com.financas.entity.Category;
import br.com.financas.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api( tags = "Categorias")
@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Listar categorias")
    @GetMapping(name = "Listar categorias")
    public List<CategoryResponseDTO> listCategories () {
        return categoryService.findAll().stream().map(category -> CategoryResponseDTO.convertToCategoryDTO(category))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Criar categoria")
    @PostMapping(name = "Criar categoria")
    public  ResponseEntity<CategoryResponseDTO> insert(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category categorySave = categoryService.insert(categoryRequestDTO.convertToEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponseDTO.convertToCategoryDTO(categorySave));
    }

    @ApiOperation(value = "Listar categoria pelo Id")
    @GetMapping(name = "Listar categoria pelo Id", path = {"/{id}"})
    public ResponseEntity<CategoryResponseDTO> find(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.isPresent() ? ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(category.get())) : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Atualizar categoria")
    @PutMapping(name = "Atualizar categoria", path = {"/{id}"})
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO categoryDto) {
        Category categoryUpdate = categoryService.update(categoryDto.convertToEntity(id));
        return ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(categoryUpdate));
    }

    @ApiOperation(value = "Deletar categoria")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "Deletar categoria", path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }


}
