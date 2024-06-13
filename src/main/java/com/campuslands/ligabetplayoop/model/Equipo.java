package com.campuslands.ligabetplayoop.model;

import jakarta.persistence.*; 
import lombok.*; 

import java.util.List; 

@Entity 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder 
public class Equipo { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    private String nombre; 

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<CuerpoTecnico> cuerpoTecnico;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<CuerpoMedico> cuerpoMedico;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL) 
    private List<Jugador> jugadores; 

}
