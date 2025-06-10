package com.femcoders.phrases.services;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.repositories.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository eventRepository;

    public PhraseService(PhraseRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Phrase> getAllPhrases() {
        return eventRepository.findAll();
    }
}
