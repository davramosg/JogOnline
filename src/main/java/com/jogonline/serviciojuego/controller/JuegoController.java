package com.jogonline.serviciojuego.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jogonline.serviciojuego.model.ModelJuego;
import com.jogonline.serviciojuego.service.JuegoService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping ("/api/juego")
public class JuegoController {

    @Autowired 
    private JuegoService juegoService;

    @GetMapping
    public List<ModelJuego> getjuegos() {
        return juegoService.getjuegos();
    }

   
    
    @PostMapping
    public ModelJuego createjuego(@RequestBody ModelJuego juego) {
        return juegoService.createjuego(juego);
    }

    @PutMapping
    public ModelJuego updatejuego(@RequestBody ModelJuego juego) {
        return juegoService.updatejuego(juego.getId(), juego);
    }

    @GetMapping ("/{id}")
    public ModelJuego getjuegobyid(@PathVariable Long id) {
        return juegoService.getjuegobyid(id);
    }

    @GetMapping ("/category/{category}")
    public List<ModelJuego> getjuegosbycategory(@PathVariable String category) {
        return juegoService.getjuegosbycategory(category);
    }

    @GetMapping ("/title/{title}")
    public List<ModelJuego> getjuegosbytitle(@PathVariable String title) {
        return juegoService.getjuegosbytitle(title);
    }   

    @DeleteMapping("/{id}") 
    public void deletejuego(@PathVariable Long id) {
        juegoService.deletejuego(id);

    }

    @DeleteMapping 
    public void deletejuegos() {
        List<ModelJuego> juegos = juegoService.getjuegos();
        for (ModelJuego juego : juegos) {
            juegoService.deletejuego(juego.getId());
        }
    }




}
