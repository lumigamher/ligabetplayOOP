package com.campuslands.ligabetplayoop.service;

import com.campuslands.ligabetplayoop.model.*;
import com.campuslands.ligabetplayoop.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;
    private final CuerpoTecnicoRepository cuerpoTecnicoRepository;
    private final CuerpoMedicoRepository cuerpoMedicoRepository;

    public EquipoService(EquipoRepository equipoRepository, JugadorRepository jugadorRepository,
                         CuerpoTecnicoRepository cuerpoTecnicoRepository, CuerpoMedicoRepository cuerpoMedicoRepository) {
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
        this.cuerpoTecnicoRepository = cuerpoTecnicoRepository;
        this.cuerpoMedicoRepository = cuerpoMedicoRepository;
    }

    // --- Métodos para Equipos ---

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> obtenerEquipoPorId(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo actualizarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    // --- Métodos para Jugadores ---

    public Jugador agregarJugadorAEquipo(Long equipoId, Jugador jugador) {
        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado con ID: " + equipoId));
        jugador.setEquipo(equipo);
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> obtenerJugadoresPorEquipo(Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }

    // --- Métodos para Cuerpo Técnico ---

    public CuerpoTecnico agregarCuerpoTecnicoAEquipo(Long equipoId, CuerpoTecnico cuerpoTecnico) {
        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado con ID: " + equipoId));
        cuerpoTecnico.setEquipo(equipo);
        return cuerpoTecnicoRepository.save(cuerpoTecnico);
    }

    public List<CuerpoTecnico> obtenerCuerpoTecnicoPorEquipo(Long equipoId) {
        return cuerpoTecnicoRepository.findByEquipoId(equipoId);
    }

    // --- Métodos para Cuerpo Médico ---

    public CuerpoMedico agregarCuerpoMedicoAEquipo(Long equipoId, CuerpoMedico cuerpoMedico) {
        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new IllegalArgumentException("Equipo no encontrado con ID: " + equipoId));
        cuerpoMedico.setEquipo(equipo);
        return cuerpoMedicoRepository.save(cuerpoMedico);
    }

    public List<CuerpoMedico> obtenerCuerpoMedicoPorEquipo(Long equipoId) {
        return cuerpoMedicoRepository.findByEquipoId(equipoId);
    }
}
