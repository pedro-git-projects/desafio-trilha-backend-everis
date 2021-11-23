package br.com.financas.service;

import br.com.financas.entity.Entry;
import br.com.financas.repository.CategoryRepository;
import br.com.financas.repository.EntryRepository;
import br.com.financas.exception.DataIntegrityViolationException;
import br.com.financas.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Entry findById(final Long id) {
        try {
            return entryRepository.findById(id).orElse(null);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado!: " + id + ", Tipo: " + Entry.class.getName());
        }
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry insert(Entry _entry) {
        try {
            return entryRepository.save(_entry);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public void update(final Entry _entry) {
        findById(_entry.getId());
        try {
            entryRepository.save(_entry);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public void delete(final Long id) {
        findById(id);
        try {
            entryRepository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível excluir o lançamento");
        }
    }

    public List<Entry> findByTitle(final String title) {
        return entryRepository.findByTitle(title);
    }

    public List<Entry> findByPaid(boolean paid) {
        return entryRepository.findByPaid(paid);
    }



}
