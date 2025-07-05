package com.kritica.flashcard.service;

import com.kritica.flashcard.entity.FlashCard;

import java.util.List;

public interface FlashCardService {
    public List<FlashCard> getFlashCardsByCategory(String category);
    public List<FlashCard> getAllFlashCards();
    public FlashCard getRandomFlashCard();
    public FlashCard createFlashCard(FlashCard flashCard);
    public void deleteFlashCard(Long id);
    public FlashCard updateFlashCard(Long id, FlashCard flashCard);

    FlashCard getFlashCardById(Long id);
}
