package com.kritica.flashcard.controller;

import com.kritica.flashcard.entity.FlashCard;
import com.kritica.flashcard.exception.ProductNotFoundException;
import com.kritica.flashcard.exception.ProductNotFoundExceptionDto;
import com.kritica.flashcard.repository.FlashCardRepository;
import com.kritica.flashcard.service.FlashCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/flashcards")
public class FlashCardController {
    private final FlashCardService flashCardService;
    private final FlashCardRepository repository;

    public FlashCardController(FlashCardService flashCardService,FlashCardRepository flashCardRepository) {
        this.repository=flashCardRepository;
        this.flashCardService = flashCardService;
    }

    @GetMapping("/all")
    public List<FlashCard> getAllFlashCards() {
        return flashCardService.getAllFlashCards();
    }

    @GetMapping("/random")
    public FlashCard getRandomFlashCard() {
        return flashCardService.getRandomFlashCard();
    }

    @GetMapping("/category/{category}")
    public List<FlashCard> getFlashCardsByCategory(@PathVariable String category) {
        return flashCardService.getFlashCardsByCategory(category);
    }

    @PostMapping
    public FlashCard createFlashCard(@RequestBody FlashCard flashCard) throws ProductNotFoundException {

        throw new ProductNotFoundException("ProductNotFoundExceptionDto");
        //return flashCardService.createFlashCard(flashCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlashCard> updateFlashCard(
            @PathVariable Long id,
            @RequestBody FlashCard flashCard) {
        return ResponseEntity.ok(flashCardService.updateFlashCard(id, flashCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashCard(@PathVariable Long id) {
        flashCardService.deleteFlashCard(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashCard> getFlashCard(@PathVariable Long id) {
        return ResponseEntity.ok(flashCardService.getFlashCardById(id));
    }
    @GetMapping
    public List<FlashCard> getFlashcards(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String topic
    ) {
        if (category != null && topic != null) {
            return repository.findByCategoryAndTopic(category, topic);
        } else if (category != null) {
            return repository.findByCategory(category);
        } else if (topic != null) {
            return repository.findByTopic(topic);
        } else {
            return repository.findAll();
        }
    }

    @GetMapping("/meta")
    public Map<String, List<String>> getMetadata() {
        Map<String, List<String>> meta = new HashMap<>();
        meta.put("categories", repository.findDistinctCategories());
        meta.put("topics", repository.findDistinctTopics());
        return meta;
    }

}

