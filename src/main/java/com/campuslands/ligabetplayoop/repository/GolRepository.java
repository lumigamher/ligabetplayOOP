package com.campuslands.ligabetplayoop.repository;

import com.campuslands.ligabetplayoop.model.Gol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GolRepository extends JpaRepository<Gol, Long> {
    List<Gol> findByPartidoId(Long partidoId); // 1
}
