package com.jogonline.serviciojuego.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.jogonline.serviciojuego.model.ModelJuego;
import com.jogonline.serviciojuego.repository.JuegoRepository;

@Service
public class JuegoServiceImpl implements JuegoService {

    private final JuegoRepository juegoRepository;

    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
    public List<ModelJuego> getjuegos() {
        return juegoRepository.findAll();
    }

    @Override
    public List<ModelJuego> getjuegosbycategory(String category) {
        return juegoRepository.findByCategory(category);
    }

    @Override 
    public List<ModelJuego> getjuegosbytitle(String title) {
        return juegoRepository.findByTitle(title);
    }

    @Override
    public ModelJuego getjuegobyid(Long id) {
        return juegoRepository.findById(id).orElse(null);
    }

    @Override
    public ModelJuego createjuego(ModelJuego juego) {
        return juegoRepository.save(juego);
    }

    @Override
    public ModelJuego updatejuego(Long id, ModelJuego juego) {
        ModelJuego existingJuego = juegoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el juego con id " + id));

        existingJuego.setTitle(juego.getTitle());
        existingJuego.setDescription(juego.getDescription());
        existingJuego.setGenre(juego.getGenre());
        existingJuego.setCategory(juego.getCategory());
        existingJuego.setImage(juego.getImage());
        existingJuego.setEnlacejuego(juego.getEnlacejuego());

        return juegoRepository.save(existingJuego);
    }

    @Override
    public void deletejuego(Long id) {
        if (!juegoRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el juego con id " + id);
        }
        juegoRepository.deleteById(id);
    }
}
