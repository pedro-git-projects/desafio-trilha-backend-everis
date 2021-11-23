package br.com.financas.controller;

import br.com.financas.dto.entry.EntryRequestDTO;
import br.com.financas.dto.entry.EntryResponseDTO;
import br.com.financas.entity.Entry;
import br.com.financas.service.EntryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api( tags = "Lançamentos")
@RestController
@RequestMapping("/lancamentos")
public class EntryController {

    @Autowired
    private EntryService service;

    @ApiOperation(value = "Listar Lançamentos")
    @GetMapping(name = "Listar Lançamentos")
    public List<EntryResponseDTO> findAll() {
      return service.findAll().stream().map(entry -> EntryResponseDTO.convertEntryDTO(entry)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Criar Lançamento")
    @PostMapping("/{idCategory}")
    public ResponseEntity<EntryResponseDTO> insert(@PathVariable Long idCategory, @Valid @RequestBody EntryRequestDTO entryDTO) {
        Entry entry = service.insert(entryDTO.convertToEntity(idCategory));
        return ResponseEntity.status(HttpStatus.CREATED).body(EntryResponseDTO.convertEntryDTO(entry));
    }

//    @GetMapping(value = "/{id}")
//    @ResponseBody
//    public  EntryDTO find(@PathVariable Long id) {
//        return convertToDTO(service.findById(id));
//    }
//
//
//    @PutMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@Valid @RequestBody EntryDTO entryDTO, BindingResult bindingResult) throws ParseException {
//        if(bindingResult.hasErrors())
//            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
//        Entry _entry = convertToEntity(entryDTO);
//        service.update(_entry);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Long id) {
//        service.delete(id);
//    }
//
//    @GetMapping(value = "/byTitle/{title}")
//    public ResponseEntity<Collection<Entry>> findByTitle(@PathVariable String title) {
//        Collection<Entry> entries = service.findByTitle(title);
//        return ResponseEntity.ok(entries);
//    }
//
//    @GetMapping(value = "/paid")
//    public ResponseEntity<Collection<Entry>> findByPaid() {
//        Collection<Entry> entries = service.findByPaid(true);
//        return ResponseEntity.ok(entries);
//    }

//    @GetMapping("lista/dashboard/{categoryID}/{entryID}")
//    public ResponseEntity<List<ChartDTO>> listaGrafico(@PathVariable Long categoryID, @PathVariable Long entryID) {
//        List<ChartDTO> resultado = service.listaGrafico(categoryID, entryID);
//        return ResponseEntity.ok(resultado);
//    }


}
