package br.com.finances.service;

import br.com.finances.entity.Category;
import br.com.finances.entity.Entry;
import br.com.finances.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Optional<Entry> findById(Long id) {
        return entryRepository.findById(id);
    }

    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    public Entry update(final Entry entry) {
        return entryRepository.save(entry);
    }

    public void delete(final Long id) {
            entryRepository.deleteById(id);
    }

    public Collection<Entry> findByPaid(boolean paid) {
        return entryRepository.findByPaid(paid);
    }



}