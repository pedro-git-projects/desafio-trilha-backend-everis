package br.com.financas.model.service;

import br.com.financas.model.dto.ChartDTO;
import br.com.financas.model.entities.Entry;
import br.com.financas.model.repository.CategoryRepository;
import br.com.financas.model.repository.EntryRepository;
import br.com.financas.model.service.exceptions.DataIntegrityViolationException;
import br.com.financas.model.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Entry findById(final Long id) {
        try {
            return entryRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Objeto não encontrado!: " + id + ", Tipo: " + Entry.class.getName());
        }
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry insert(final Entry _entry) {
        try {
            return entryRepository.save(_entry);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Campo(s) obrigatório(s) não foram preenchidos");
        }
    }

    public  Entry update(final Entry _entry) {
        findById(_entry.getId());
        try {
            return entryRepository.save(_entry);
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

    public  List<ChartDTO> listaGrafico(Long idCategoria, Long idLancamento) {
        return new ArrayList<>();
    }


}
