package br.com.financas.controller;


import br.com.financas.model.Entry;
import br.com.financas.service.EntryService;
import br.com.financas.service.excepctions.ConstraintException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping(value = "/entries")
public class EntryController {

    @Autowired
    private EntryService service;

    @GetMapping
    public ResponseEntity<Collection<Entry>> findAll() {
        Collection<Entry> entries = service.findAll();
        return ResponseEntity.ok().body(entries);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Entry> find(@PathVariable Long id) {
        Entry _entry = service.findById(id);
        return ResponseEntity.ok().body(_entry);
    }

    @PostMapping
    public ResponseEntity<Entry> insert(@Valid @RequestBody Entry _entry, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        _entry = service.insert(_entry);
        return ResponseEntity.ok().body(_entry);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Entry> update(@Valid @RequestBody Entry _entry, BindingResult bindingResult) {
          if(bindingResult.hasErrors())
              throw new ConstraintException(bindingResult.getAllErrors().get(0).getDefaultMessage());
          _entry = service.update(_entry);
          return  ResponseEntity.ok().body(_entry);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
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
}
