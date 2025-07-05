package com.kritica.flashcard.service;

import com.kritica.flashcard.entity.FlashCard;
import com.kritica.flashcard.repository.FlashCardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlashCardServiceImpl implements FlashCardService {
    private final FlashCardRepository flashCardRepository;
    private final Random random = new Random();

    public FlashCardServiceImpl(FlashCardRepository flashCardRepository) {
        this.flashCardRepository = flashCardRepository;
    }

    public List<FlashCard> getAllFlashCards() {
        return flashCardRepository.findAll();
    }

    public FlashCard getRandomFlashCard() {
        List<FlashCard> allCards = flashCardRepository.findAll();
        if (allCards.isEmpty()) {
            throw new RuntimeException("No flash cards available");
        }
        return allCards.get(random.nextInt(allCards.size()));
    }

    public List<FlashCard> getFlashCardsByCategory(String category) {
        return flashCardRepository.findByCategory(category);
    }

    public FlashCard createFlashCard(FlashCard flashCard) {
        return flashCardRepository.save(flashCard);
    }

    public FlashCard updateFlashCard(Long id, FlashCard flashCard) {
        return flashCardRepository.findById(id)
                .map(existingCard -> {
                    existingCard.setQuestion(flashCard.getQuestion());
                    existingCard.setAnswer(flashCard.getAnswer());
                    existingCard.setCodeSnippet(flashCard.getCodeSnippet());
                    existingCard.setCategory(flashCard.getCategory());
                    return flashCardRepository.save(existingCard);
                })
                .orElseThrow(() -> new RuntimeException("Flash card not found with id: " + id));
    }

    @Override
    public FlashCard getFlashCardById(Long id) {
        return flashCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flash card not found with id: " + id));
    }

    public void deleteFlashCard(Long id) {
        if (!flashCardRepository.existsById(id)) {
            throw new RuntimeException("Flash card not found with id: " + id);
        }
        flashCardRepository.deleteById(id);
    }

}

