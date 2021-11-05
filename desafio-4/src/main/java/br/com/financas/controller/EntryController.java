package br.com.financas.controller;

import br.com.financas.model.Entry;
import br.com.financas.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EntryController {
    @Autowired
    EntryRepository entryRepository;

    @GetMapping("/entries")
    public ResponseEntity<List<Entry>> getAllEntries(@RequestParam(required = false) String title) {
        List<Entry> entries = new ArrayList<>();
        try {
            if (title == null) {
                entryRepository.findAll().forEach(entries::add);
            } else {
                entryRepository.findByTitle(title).forEach(entries::add);
            }
            if (entries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = {"/entries/{id}"})
    public ResponseEntity<Entry> getEntryById(@PathVariable Long id) {
        Optional<Entry> entryData = entryRepository.findById(id);
        System.out.println(entryData);
        return entryData.map(entry -> new ResponseEntity<>(entry, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/entries")
    public  ResponseEntity<Entry> createEntry(@RequestBody Entry entry) {
        try {
            Entry _entry = entryRepository
                    .save(new Entry( entry.getTitle(), entry.getDescription(), entry.getType(),entry.getAmount(),entry.getDate(), false));
            return  new ResponseEntity<>(_entry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // not working
    @PutMapping("/entries/{id}")
    public ResponseEntity<Entry> updateEntry(@PathVariable("id") long id, @RequestBody Entry entry) {
        Optional<Entry> entryData = entryRepository.findById(id);

        if(entryData.isPresent()) {
            Entry _entry = entryData.get();
            _entry.setTitle(entry.getTitle());
            _entry.setDescription(entry.getDescription());
            _entry.setType(entry.getType());
            _entry.setAmount(entry.getAmount());
            _entry.setDate(entry.getDate());
            _entry.setPaid(entry.isPaid());
            return new ResponseEntity<>(entryRepository.save(_entry), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // not working
    @DeleteMapping("/entries/{id}")
    public ResponseEntity<HttpStatus> deleteEntry(@PathVariable("id") long id) {
        try {
            entryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //not working
    @DeleteMapping("/entries")
    public ResponseEntity<HttpStatus> deleteAllEntries() {
        try {
            entryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/entries/paid")
    public ResponseEntity<List<Entry>> findByPublished() {
        try {
            List<Entry> entries = entryRepository.findByPaid(true);

            if (entries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } return new ResponseEntity<>(entries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}