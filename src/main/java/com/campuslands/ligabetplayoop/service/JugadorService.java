package com.campuslands.ligabetplayoop.service;

import com.campuslands.ligabetplayoop.model.Equipo;
import com.campuslands.ligabetplayoop.model.Jugador;
import com.campuslands.ligabetplayoop.repository.EquipoRepository;
import com.campuslands.ligabetplayoop.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository; // 1
    
    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    // Método para crear un nuevo jugador y asociarlo a un equipo
    public Jugador crearJugador(Jugador jugador, Long equipoId) {
        Optional<Equipo> equipoOptional = equipoRepository.findById(equipoId); // 2

        if (equipoOptional.isPresent()) {
            Equipo equipo = equipoOptional.get();
            jugador.setEquipo(equipo);
            return jugadorRepository.save(jugador);
        } else {
            throw new IllegalArgumentException("Equipo no encontrado con ID: " + equipoId); // 3
        }
    }

    // Método para obtener todos los jugadores
    public List<Jugador> obtenerTodosLosJugadores() {
        return jugadorRepository.findAll();
    }

    // Método para obtener un jugador por ID
    public Optional<Jugador> obtenerJugadorPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    // Método para actualizar un jugador
    public Jugador actualizarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Método para eliminar un jugador por ID
    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
