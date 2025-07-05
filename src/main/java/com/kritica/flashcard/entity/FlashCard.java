package com.kritica.flashcard.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String topic;
    private Long followUp;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column(name = "code_snippet", columnDefinition = "TEXT")
    private String codeSnippet;

    private String category;
}

