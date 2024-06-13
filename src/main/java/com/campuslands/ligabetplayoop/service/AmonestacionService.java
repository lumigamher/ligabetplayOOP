package com.campuslands.ligabetplayoop.service;

import com.campuslands.ligabetplayoop.model.Amonestacion;
import com.campuslands.ligabetplayoop.repository.AmonestacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmonestacionService {

    private final AmonestacionRepository amonestacionRepository;

    public AmonestacionService(AmonestacionRepository amonestacionRepository) {
        this.amonestacionRepository = amonestacionRepository;
    }

    // Método para registrar una amonestación
    public Amonestacion registrarAmonestacion(Amonestacion amonestacion) {
        return amonestacionRepository.save(amonestacion);
    }

    // Método para obtener todas las amonestaciones
    public List<Amonestacion> obtenerTodasLasAmonestaciones() {
        return amonestacionRepository.findAll();
    }
}
