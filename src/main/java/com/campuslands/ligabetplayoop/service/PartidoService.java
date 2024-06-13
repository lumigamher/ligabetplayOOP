package com.campuslands.ligabetplayoop.service;

import com.campuslands.ligabetplayoop.model.Amonestacion;
import com.campuslands.ligabetplayoop.model.Gol;
import com.campuslands.ligabetplayoop.model.Partido;
import com.campuslands.ligabetplayoop.repository.AmonestacionRepository;
import com.campuslands.ligabetplayoop.repository.EquipoRepository;
import com.campuslands.ligabetplayoop.repository.GolRepository;
import com.campuslands.ligabetplayoop.repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;
    // private final EquipoRepository equipoRepository;
    private final GolRepository golRepository;
    private final AmonestacionRepository amonestacionRepository;

    public PartidoService(PartidoRepository partidoRepository, EquipoRepository equipoRepository,
                         GolRepository golRepository, AmonestacionRepository amonestacionRepository) {
        this.partidoRepository = partidoRepository;
        // this.equipoRepository = equipoRepository;
        this.golRepository = golRepository;
        this.amonestacionRepository = amonestacionRepository;
    }

    // --- Métodos para Partidos ---

    public Partido crearPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public List<Partido> obtenerTodosLosPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> obtenerPartidoPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido actualizarPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void eliminarPartido(Long id) {
        partidoRepository.deleteById(id);
    }

    // --- Métodos para Goles ---

    public Gol registrarGol(Long partidoId, Gol gol) {
        Partido partido = partidoRepository.findById(partidoId)
                .orElseThrow(() -> new IllegalArgumentException("Partido no encontrado con ID: " + partidoId));
        gol.setPartido(partido);
        return golRepository.save(gol);
    }

    public List<Gol> obtenerGolesPorPartido(Long partidoId) {
        return golRepository.findByPartidoId(partidoId);
    }

    // --- Métodos para Amonestaciones ---

    public Amonestacion registrarAmonestacion(Long partidoId, Amonestacion amonestacion) {
        Partido partido = partidoRepository.findById(partidoId)
                .orElseThrow(() -> new IllegalArgumentException("Partido no encontrado con ID: " + partidoId));
        amonestacion.setPartido(partido);
        return amonestacionRepository.save(amonestacion);
    }

    public List<Amonestacion> obtenerAmonestacionesPorPartido(Long partidoId) {
        return amonestacionRepository.findByPartidoId(partidoId);
    }
}
