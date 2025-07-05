package com.kritica.flashcard.repository;

import com.kritica.flashcard.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {

    List<FlashCard> findByCategoryAndTopic(String category, String topic);
    List<FlashCard> findByCategory(String category);
    List<FlashCard> findByTopic(String topic);

    @Query("SELECT DISTINCT f.category FROM FlashCard f")
    List<String> findDistinctCategories();

    @Query("SELECT DISTINCT f.topic FROM FlashCard f")
    List<String> findDistinctTopics();
}

