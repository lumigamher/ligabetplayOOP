package com.campuslands.ligabetplayoop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    private int golesLocal;
    private int golesVisitante;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<Gol> goles;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<Amonestacion> amonestaciones;
}
