package com.proyecto.proyecto_final.service;

import com.proyecto.proyecto_final.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> listarPersonas();
    Optional<Persona> buscarPersona(Integer idPersona);
    Persona guardarPersona(Persona persona);
    void eliminarPersona(Integer idPersona);
}
