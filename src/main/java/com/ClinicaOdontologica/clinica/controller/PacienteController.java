package com.ClinicaOdontologica.clinica.controller;

import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.ClinicaOdontologica.clinica.service.PacienteService;
import com.ClinicaOdontologica.clinica.service.interfaces.IOdontologoService;
import com.ClinicaOdontologica.clinica.service.interfaces.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @GetMapping
    public Collection<Paciente> traerPacientes() {
        return pacienteService.traerTodos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente){
        pacienteService.crearPaciente(paciente);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> actualizarOdontologo(@RequestBody Paciente paciente) {
        pacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id){
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        if (paciente == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El paciente no fue encontrado");
        }

        pacienteService.eliminarPaciente(id);

        return ResponseEntity.ok("El paciente ha sido eliminado correctamente");
    }


    @GetMapping("/buscar/{id}")
    public Paciente obtenerPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.obtenerPacientePorId(id);
    }



}
