package com.campuslands.ligabetplayoop.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int dorsal;
    private String posicion;
    private LocalDate fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    //Estadisticas 
    private int golesAnotados;
    private int tarjetasAmarillos;
    private int tarjetaRojas;
    
}
