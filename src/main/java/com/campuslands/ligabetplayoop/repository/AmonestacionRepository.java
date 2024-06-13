package com.campuslands.ligabetplayoop.repository;

import com.campuslands.ligabetplayoop.model.Amonestacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmonestacionRepository extends JpaRepository<Amonestacion, Long> {
    List<Amonestacion> findByPartidoId(Long partidoId); // 1
}
