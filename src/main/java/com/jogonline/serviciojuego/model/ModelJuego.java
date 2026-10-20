package com.jogonline.serviciojuego.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "juego")
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class ModelJuego {
    
    @Column (name = "title", columnDefinition = "TEXT")
    private String title;

    
    @Column (name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column (name = "genre", columnDefinition = "TEXT")
    private String genre;
    
    @Column (name = "category", columnDefinition = "TEXT")
    private String category;

    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column (name = "image", columnDefinition = "TEXT")
    private String image;

    @Column (name = "enlacejuego", columnDefinition = "TEXT")
    private String enlacejuego;

}
