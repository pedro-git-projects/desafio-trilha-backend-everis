package br.com.finances.service;

import br.com.finances.dto.request.EntryRequestDTO;
import br.com.finances.dto.response.ChartResponseDTO;
import br.com.finances.entity.Entry;
import br.com.finances.repository.CategoryRepository;
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
            return  entryRepository.findById(id).orElse(null);
    }

    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    // Bloco Try Catch está quebrando o update
    public Entry update(final Entry entry) {
        return entryRepository.save(entry);
    }

    public void delete(final Long id) {
        findById(id);
        entryRepository.deleteById(id);
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