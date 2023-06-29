package com.ClinicaOdontologica.clinica.controller;


import com.ClinicaOdontologica.clinica.model.dto.OdontologoDTO;
import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.service.impl.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;


//    private static final Logger logger = Logger.getLogger(String.valueOf(OdontologoController.class));

    @GetMapping
    public Collection<OdontologoDTO> traerOdontologos() {
        return odontologoService.traerTodos();
    }

    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.crearOdontologo(odontologo);
        return ResponseEntity.ok(odontologo);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo) {
        odontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping("/buscar/{id}")
    public Odontologo obtenerOdontologo(@PathVariable Long id) throws Exception {
        return odontologoService.obtenerOdontologoPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id){
        Odontologo odontologo = odontologoService.obtenerOdontologoPorId(id);
        if (odontologo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El odontólogo no fue encontrado");
        }

        odontologoService.eliminarOdontologo(id);

        return ResponseEntity.ok("El odontólogo ha sido eliminado correctamente");
    }


}
