package com.campuslands.ligabetplayoop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuerpoTecnico extends Persona { // Hereda de Persona

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    private String cargo; // "Entrenador", "Asistente", etc.

    public static Persona.PersonaBuilder builder() {
        return Persona.builder();
    }
}