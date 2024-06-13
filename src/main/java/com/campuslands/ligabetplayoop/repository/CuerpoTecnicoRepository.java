package com.campuslands.ligabetplayoop.repository;

import com.campuslands.ligabetplayoop.model.CuerpoTecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CuerpoTecnicoRepository extends JpaRepository<CuerpoTecnico, Long> {
    List<CuerpoTecnico> findByEquipoId(Long equipoId);
}