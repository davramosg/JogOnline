package com.jogonline.serviciojuego.service;

import java.util.List;

import com.jogonline.serviciojuego.model.ModelJuego;

public interface JuegoService {
    List<ModelJuego> getjuegos();
    List<ModelJuego> getjuegosbycategory(String category);
    ModelJuego getjuegobyid(Long id);
    ModelJuego createjuego(ModelJuego juego);
    ModelJuego updatejuego(Long id, ModelJuego juego);
    List<ModelJuego> getjuegosbytitle(String title);
    void deletejuego(Long id);

}
