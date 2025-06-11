package com.femcoders.phrases.controllers;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.services.PhraseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/list-of-phrases")
    public List<Phrase> getAllPhrases() {
        return phraseService.getAllPhrases();
    }
}
