package com.campuslands.ligabetplayoop.repository;

import com.campuslands.ligabetplayoop.model.CuerpoMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuerpoMedicoRepository extends JpaRepository<CuerpoMedico, Long> {
    List<CuerpoMedico> findByEquipoId(Long equipoId);
}