package br.com.finances.service;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import br.com.finances.exception.DataIntegrityViolationException;
import br.com.finances.exception.ObjectNotFoundException;
import br.com.finances.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry findById(final Long id) {
        try {
            return  entryRepository.findById(id).orElse(null);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado!: " +  id + ", Tipo: " + Entry.class.getName());
        }
    }

    public Entry save(Entry entry) {
        try {
            return entryRepository.save(entry);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    // Bloco Try Catch está quebrando o update
    public Entry update(final Entry entry) {
        return entryRepository.save(entry);
    }

    public void delete(final Long id) {
        findById(id);
        try {
            entryRepository.deleteById(id);
        } catch (final DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível excluir o lançamento.");
        }
    }

    public Collection<Entry> findByPaid(boolean paid) {
        return entryRepository.findByPaid(paid);
    }



}