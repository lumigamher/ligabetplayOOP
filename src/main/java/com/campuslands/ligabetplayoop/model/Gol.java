package com.campuslands.ligabetplayoop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partido_id")
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    private int minuto;
}