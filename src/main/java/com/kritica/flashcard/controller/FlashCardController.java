package com.kritica.flashcard.controller;

import com.kritica.flashcard.entity.FlashCard;
import com.kritica.flashcard.service.FlashCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
public class FlashCardController {
    private final FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @GetMapping
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
    public FlashCard createFlashCard(@RequestBody FlashCard flashCard) {
        return flashCardService.createFlashCard(flashCard);
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


}

