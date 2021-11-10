package br.com.financas.service;


import br.com.financas.model.Category;
import br.com.financas.repository.CategoryRepository;
import br.com.financas.service.excepctions.DataIntegrityViolationException;
import br.com.financas.service.excepctions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(final Long id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado!: " + id + ", Tipo: " + Category.class.getName());
        }
    }

    public Collection<Category> findAll() {
        return repository.findAll();
    }

    public Category insert(final Category _category) {
        try {
            return repository.save(_category);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public  Category update(final Category _category) {
        findById(_category.getId());
        try {
            return repository.save(_category);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public void delete(final Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível excluir o lançamento");
        }
    }

    public Collection<Category> findByTitle(final String title) {
        return repository.findByTitle(title);
    }

}
