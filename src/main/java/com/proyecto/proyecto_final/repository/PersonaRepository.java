package com.proyecto.proyecto_final.repository;

import com.proyecto.proyecto_final.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
