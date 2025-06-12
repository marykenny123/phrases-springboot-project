package com.femcoders.phrases.services;

import com.femcoders.phrases.models.Phrase;
import com.femcoders.phrases.repositories.PhraseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
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

    public boolean updatePhrase(Long id, Phrase updatedDetails) {
        Optional<Phrase> phraseOptional = phraseRepository.findById(id);
        if (!phraseOptional.isPresent()) {
            return false;
        }
        Phrase existingPhrase = phraseOptional.get();

        existingPhrase.setText(updatedDetails.getText());
        existingPhrase.setAuthor(updatedDetails.getAuthor());
        phraseRepository.save(existingPhrase);
        return true;
    }


    public Phrase getPhraseById(Long id) {
        return phraseRepository.findById(id).orElse(null);
    }




}
