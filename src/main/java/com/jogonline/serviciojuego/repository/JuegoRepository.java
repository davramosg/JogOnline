package com.jogonline.serviciojuego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jogonline.serviciojuego.model.ModelJuego;

public interface JuegoRepository extends JpaRepository<ModelJuego, Long> {

    List<ModelJuego> findByCategory(String category);
    List<ModelJuego> findByTitle(String title);
}
