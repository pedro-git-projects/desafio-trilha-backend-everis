package br.com.finances.controller;

import br.com.finances.dto.request.ChartRequestDTO;
import br.com.finances.dto.response.CategoryResponseDTO;
import br.com.finances.dto.response.ChartResponseDTO;
import br.com.finances.dto.response.EntryResponseDTO;
import br.com.finances.entity.Entry;
import br.com.finances.service.exception.DivisionByZeroException;
import br.com.finances.service.exception.handler.RestExceptionHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.finances.dto.request.EntryRequestDTO;
import br.com.finances.service.EntryService;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Api( tags = "Lançamentos")
@RestController
@RequestMapping("/lancamentos")
public class EntryController {

    @Autowired
    private EntryService service;

    @ApiOperation(value = "Listar lançamentos")
    @GetMapping(name = "Listar lançamentos")
    public List<EntryResponseDTO> list () {
        return service.findAll().stream().map(EntryResponseDTO::convertEntryDTO)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Listar lançamento pelo Id")
    @GetMapping(name = "Listar lançamento pelo Id", path = {"/{id}"})
    public ResponseEntity<EntryResponseDTO> find(@PathVariable Long id) {
        Optional<Entry> entry = Optional.ofNullable(service.findById(id));
        return entry.map(value -> ResponseEntity
                        .ok(EntryResponseDTO.convertEntryDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Criar lançamento")
    @PostMapping("/{categoryID}")
    public  ResponseEntity<EntryResponseDTO> insert(@PathVariable Long categoryID, @Valid @RequestBody EntryRequestDTO entryRequestDTO) {
        Entry entrySave = service.save(entryRequestDTO.convertToEntity(categoryID));
        return ResponseEntity.status(HttpStatus.CREATED).body(EntryResponseDTO.convertEntryDTO(entrySave));
    }

    @ApiOperation(value = "Atualizar lançamento")
    @PutMapping(name = "Atualizar lançamento", path = {"/{id}"})
    public ResponseEntity<EntryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EntryRequestDTO entryRequestDTO) {
        Entry entryUpdate = service.update(entryRequestDTO.convertToEntity(id));
        return ResponseEntity.ok(EntryResponseDTO.convertEntryDTO(entryUpdate));
    }


    @ApiOperation(value = "Deletar lançamento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "Deletar lançamento", path = {"/{id}"})
    public void delete(@PathVariable Long id) {service.delete(id);
    }

    @ApiOperation(value = "Retornar lançamentos pagos")
    @GetMapping(value = "/paid")
    public ResponseEntity<Collection<Entry>> findByPaid() {
        Collection<Entry> entries = service.findByPaid(true);
        return ResponseEntity.ok(entries);
    }

    @ApiOperation(value = "Retorna gráfico")
    @GetMapping("/chart")
    public List<EntryRequestDTO> getDTO() {
        return service.getListDTO();
    }

    @ApiOperation(value = "Calcula média")
    @GetMapping("/calcula/{x}/{y}")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y) {
        Integer calculaMedia = service.calculaMedia(x, y);
        return ResponseEntity.ok(calculaMedia);
    }


}

