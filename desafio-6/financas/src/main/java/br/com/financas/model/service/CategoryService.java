package br.com.financas.model.service;

import br.com.financas.model.entities.Category;
import br.com.financas.model.repository.CategoryRepository;
import br.com.financas.model.repository.EntryRepository;
import br.com.financas.model.service.exceptions.DataIntegrityViolationException;
import br.com.financas.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntryRepository entryRepository;

    public Category findById(final Long id) {
        try {
            return categoryRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado!: " + id + ", Tipo: " + Category.class.getName());
        }
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category insert(final Category _category) {
        try {
            return categoryRepository.save(_category);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public  Category update(final Category _category) {
        findById(_category.getId());
        try {
            return categoryRepository.save(_category);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public void delete(final Long id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível excluir o lançamento");
        }
    }

    public Collection<Category> findByTitle(final String title) {
        return categoryRepository.findByTitle(title);
    }

}
