package com.ClinicaOdontologica.clinica.controller;

import com.ClinicaOdontologica.clinica.entity.Paciente;
import com.ClinicaOdontologica.clinica.entity.Turno;
import com.ClinicaOdontologica.clinica.service.PacienteService;
import com.ClinicaOdontologica.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "http://localhost:63342")
public class TurnoController {


    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public Collection<Turno> traerPacientes() {
        return turnoService.traerTodos();
    }


    @PostMapping("/guardar")
    public ResponseEntity<Turno> crearPaciente(@RequestBody Turno turno){
        turnoService.crearTurno(turno);
        return ResponseEntity.ok(turno);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Turno> actualizarOdontologo(@RequestBody Turno turno) {
        turnoService.modificarTurno(turno);
        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        Turno turno = turnoService.obtenerTurnoPorId(id);
        if (turno == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El turno no fue encontrado");
        }

        turnoService.eliminarTurno(id);

        return ResponseEntity.ok("El turno ha sido eliminado correctamente");
    }

    @GetMapping("/buscar/{id}")
    public Turno obtenerTurno(@PathVariable Long id) throws Exception {
        return turnoService.obtenerTurnoPorId(id);
    }


}
