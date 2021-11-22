package br.com.financas.controller;

import br.com.financas.models.dto.ChartDTO;
import br.com.financas.models.dto.EntryDTO;
import br.com.financas.models.entities.Entry;
import br.com.financas.models.service.EntryService;
import br.com.financas.models.service.exceptions.ConstraintException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/entries")
public class EntryController {

    @Autowired
    private EntryService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseBody
    public List<EntryDTO> findAll() {
        List<Entry> entries = service.findAll();
        return entries.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public  EntryDTO find(@PathVariable Long id) {
        return convertToDTO(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EntryDTO insert(@Valid @RequestBody EntryDTO entryDTO, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        Entry entry = convertToEntity(entryDTO);
        Entry insertEntry = service.insert(entry);
        return convertToDTO(insertEntry);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody EntryDTO entryDTO, BindingResult bindingResult) throws ParseException {
        if(bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        Entry _entry = convertToEntity(entryDTO);
        service.update(_entry);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/byTitle/{title}")
    public ResponseEntity<Collection<Entry>> findByTitle(@PathVariable String title) {
        Collection<Entry> entries = service.findByTitle(title);
        return ResponseEntity.ok(entries);
    }

    @GetMapping(value = "/paid")
    public ResponseEntity<Collection<Entry>> findByPaid() {
        Collection<Entry> entries = service.findByPaid(true);
        return ResponseEntity.ok(entries);
    }

//    @GetMapping("lista/dashboard/{categoryID}/{entryID}")
//    public ResponseEntity<List<ChartDTO>> listaGrafico(@PathVariable Long categoryID, @PathVariable Long entryID) {
//        List<ChartDTO> resultado = service.listaGrafico(categoryID, entryID);
//        return ResponseEntity.ok(resultado);
//    }

    private EntryDTO convertToDTO(Entry entry) {
        EntryDTO entryDTO = modelMapper.map(entry, EntryDTO.class);
        entryDTO.setId(entry.getId());
        entryDTO.setTitle(entry.getTitle());
        entryDTO.setDescription(entry.getDescription());
        entryDTO.setType(entry.getType());
        entryDTO.setDate(entry.getDate());
        entryDTO.setPaid(entry.isPaid());
        entryDTO.setCategoryID(entry.getCategoryID());
        return entryDTO;
    }

    private Entry convertToEntity(EntryDTO entryDTO) throws ParseException {
        Entry entry = modelMapper.map(entryDTO, Entry.class);
        entry.setId(entryDTO.getId());
        entry.setTitle(entryDTO.getTitle());
        entry.setDescription(entryDTO.getDescription());
        entry.setType(entryDTO.getType());
        entry.setDate(entryDTO.getDate());
        entry.setPaid(entryDTO.isPaid());
        entry.setCategoryID(entryDTO.getCategoryID());

        if(entryDTO.getId() != null) {
            Entry oldEntry = service.findById(entryDTO.getId());
        }
        return entry;

    }
}
