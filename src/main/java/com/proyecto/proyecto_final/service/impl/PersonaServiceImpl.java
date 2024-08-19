package com.proyecto.proyecto_final.service.impl;

import com.proyecto.proyecto_final.dto.PersonaDto;
import com.proyecto.proyecto_final.entity.Persona;
import com.proyecto.proyecto_final.repository.PersonaRepository;
import com.proyecto.proyecto_final.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private PersonaRepository personaRepository;
    @Override
    public List<Persona> listarPersonas() {
        //List<Persona> personaList = personaRepository.findAll();
        //List<PersonaDto> personaDtoList = new ArrayList<>();
        //personaList.stream().forEach(persona -> personaDtoList.add());
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> buscarPersona(Integer idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(Integer idPersona) {
        Optional<Persona> personaOptional = personaRepository.findById(idPersona);
        if(!personaOptional.isPresent()){
            throw new RuntimeException("Persona no encontrada");
        }
        personaRepository.delete(personaOptional.get());
    }
}
