package com.proyecto.proyecto_final.controller;

import com.proyecto.proyecto_final.entity.Persona;
import com.proyecto.proyecto_final.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController{

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.listarPersonas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") Integer idPersona){
        Optional<Persona> persona = personaService.buscarPersona(idPersona);
        return persona.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Persona> getCreatePersona(@RequestBody Persona persona){
        Persona savePersona = personaService.guardarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePersona);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersona(@PathVariable("id") Integer idPersona){
        personaService.eliminarPersona(idPersona);
        return new ResponseEntity<>("Persona eliminada exitosamente",HttpStatus.OK);

    }


}
