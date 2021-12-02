package br.com.finances.service;

import br.com.finances.dto.request.ChartRequestDTO;
import br.com.finances.dto.request.EntryRequestDTO;
import br.com.finances.dto.response.ChartResponseDTO;
import br.com.finances.dto.response.EntryResponseDTO;
import br.com.finances.entity.Entry;
import br.com.finances.repository.CategoryRepository;
import br.com.finances.service.exception.DataIntegrityViolationException;
import br.com.finances.service.exception.ObjectNotFoundException;
import br.com.finances.repository.EntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    private CategoryRepository categoryRepository;

    private final ModelMapper mapper = new ModelMapper();

    private List<ChartResponseDTO> chartResponseDTOList = new ArrayList<>();

    public EntryService() {
    }

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

    private EntryRequestDTO mapToDTO(Entry entry) {
        return mapper.map(entry, EntryRequestDTO.class);
    }

    private Entry mapToEntity(EntryRequestDTO entryResponseDTO) {
        return mapper.map(entryResponseDTO, Entry.class);
    }

    public List<EntryRequestDTO> getListDTO() {
        List<Entry> getEntries = entryRepository.findAll();
        entryRepository.getClass();
        return getEntries.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}