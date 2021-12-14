package br.com.finances.service;

import br.com.finances.dto.request.EntryRequestDTO;
import br.com.finances.dto.response.ChartResponseDTO;
import br.com.finances.entity.Entry;
import br.com.finances.repository.CategoryRepository;
import br.com.finances.repository.EntryRepository;
import br.com.finances.service.exception.DivisionByZeroException;
import br.com.finances.service.exception.ObjectNotFoundException;
import br.com.finances.service.exception.handler.NoContentException;
import br.com.finances.service.exception.handler.NullEntryException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

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

    public Integer calculaMedia(Integer x, Integer y) throws DivisionByZeroException {
       if(y == 0) {
           throw new DivisionByZeroException("Divisão por zero não é definida");
       } else {
           return x /y;
       }
    }

    ///////////////////////////////////////
    // Método para o desafio sobre testes
    /////////////////////////////////////
    
    public List<Entry> getLancamentosDependentes(String dataLancamento, Double amount, Boolean paid) throws  NullEntryException, NoContentException {
        if (dataLancamento == null || amount == null) {
            throw new NullEntryException("Parâmetros com valores errados");
        }
        List<Entry> entries = entryRepository.findAll()
                .stream()
                .filter(entry -> entry.getDate().equals(dataLancamento)
                && entry.getAmount().equals(amount)
                && entry.getPaid() == paid)
                .collect(Collectors.toList());
        if(CollectionUtils.isEmpty(entries)) {
            throw new NoContentException("Não existe os dados pelo parâmetro passado.");
        }
        return entries;
    }
}

