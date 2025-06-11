package com.femcoders.phrases.controllers;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.services.PhraseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/list-of-phrases")
    public ResponseEntity<List<Phrase>> getAllPhrases() {
        List<Phrase> phrases = phraseService.getAllPhrases();
        return new ResponseEntity<List<Phrase>>(phrases, HttpStatus.OK);
    }

    @PostMapping("/new-phrase")
    public ResponseEntity<Phrase> addPhrase(@RequestBody Phrase newPhrase) {
        Phrase createdPhrase = phraseService.addPhrase(newPhrase);
        return new ResponseEntity<Phrase>(createdPhrase, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Phrase> deletePhrase(@PathVariable Long id) {
        boolean isDeleted = phraseService.deletePhrase(id);

        if (!isDeleted) {
            return new ResponseEntity<Phrase>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}




