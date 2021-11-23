package br.com.financas.service;

import br.com.financas.entity.Category;
import br.com.financas.repository.CategoryRepository;
import br.com.financas.repository.EntryRepository;
import br.com.financas.exception.DataIntegrityViolationException;
import br.com.financas.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntryRepository entryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    public  Category update(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
