package com.femcoders.phrases.models;

import jakarta.persistence.*;

@Entity
@Table(name="phrases")
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String author;
}
