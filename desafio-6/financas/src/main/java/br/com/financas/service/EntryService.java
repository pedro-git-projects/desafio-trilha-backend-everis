package br.com.financas.service;

import br.com.financas.model.Category;
import br.com.financas.model.Entry;
import br.com.financas.repository.CategoryRepository;
import br.com.financas.repository.EntryRepository;
import br.com.financas.service.exceptions.DataIntegrityViolationException;
import br.com.financas.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EntryService {

    @Autowired
    private EntryRepository repository;

    public Entry findById(final Long id) {
        try {
            return repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado!: " + id + ", Tipo: " + Entry.class.getName());
        }
    }

    public List<Entry> findAll() {
        return repository.findAll();
    }

    public Entry insert(final Entry _entry) {
        try {
            return repository.save(_entry);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public  Entry update(final Entry _entry) {
        findById(_entry.getId());
        try {
            return repository.save(_entry);
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

    public List<Entry> findByTitle(final String title) {
        return repository.findByTitle(title);
    }

    public List<Entry> findByPaid(boolean paid) {
        return repository.findByPaid(paid);
    }
}
