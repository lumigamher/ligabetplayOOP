package com.campuslands.ligabetplayoop.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuerpoMedico extends Persona { // Hereda de Persona

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    private String especialidad; // "Médico", "Fisioterapeuta", etc.

    public static Persona.PersonaBuilder builder() {
        return Persona.builder();
    }
}