package com.campuslands.ligabetplayoop.service;

import com.campuslands.ligabetplayoop.model.Gol;
import com.campuslands.ligabetplayoop.repository.GolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GolService {

    private final GolRepository golRepository;

    public GolService(GolRepository golRepository) {
        this.golRepository = golRepository;
    }

    // Método para registrar un gol
    public Gol registrarGol(Gol gol) {
        return golRepository.save(gol);
    }

    // Método para obtener todos los goles
    public List<Gol> obtenerTodosLosGoles() {
        return golRepository.findAll();
    }
}
