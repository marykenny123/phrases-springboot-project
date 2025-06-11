package com.femcoders.phrases.services;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.repositories.PhraseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository eventRepository) {
        this.phraseRepository = eventRepository;
    }

    public List<Phrase> getAllPhrases() {
        return phraseRepository.findAll();
    }

    public Phrase addPhrase(Phrase newPhrase) {
        return phraseRepository.save(newPhrase);
    }

    public boolean deletePhrase(Long id) {
        if (!phraseRepository.existsById(id)) {
            return false;
        }
        phraseRepository.deleteById(id);
        return true;

    }


}
