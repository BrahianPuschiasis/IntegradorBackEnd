package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.entity.Domicilio;
import com.ClinicaOdontologica.clinica.entity.Odontologo;
import com.ClinicaOdontologica.clinica.entity.Paciente;
import com.ClinicaOdontologica.clinica.entity.Turno;
import com.ClinicaOdontologica.clinica.repository.IOdontologoRepository;
import com.ClinicaOdontologica.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    OdontologoService odontologoService;

    @Autowired
    DomicilioService domicilioService;

    @Autowired
    TurnoService turnoService;

    public Collection<Paciente> traerTodos() {
        return iPacienteRepository.findAll();

    }

    public Paciente crearPaciente(Paciente paciente) {
     return iPacienteRepository.save(paciente);

    }

    public Paciente modificarPaciente(Paciente paciente) {
        return iPacienteRepository.save(paciente);
    }

    public void eliminarPaciente(Long id) {
        Optional<Paciente> pacienteOptional = iPacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            iPacienteRepository.delete(paciente);
        } else {
            throw new RuntimeException("No se encontró el paciente con ID: " + id);
        }
    }

    public Paciente obtenerPacientePorId(Long id) {
        Optional<Paciente> pacienteOptional = iPacienteRepository.findById(id);
        return pacienteOptional.orElseThrow(() -> new RuntimeException("No se encontró el paciente con ID: " + id));
    }


    public void cargarDatosDePrueba() {
        // Paciente 1
        Paciente paciente1 = new Paciente();
        paciente1.setNombre("Juan");
        paciente1.setApellido("Pérez");
        paciente1.setFechaIngreso(LocalDate.now()); // Agregar la fecha actual como fecha de ingreso
        paciente1.setDni("12345678"); // Agregar el número de documento (dni)
//        Odontologo odontologo1 = odontologoService.obtenerOdontologoPorId(1L);
//        paciente1.setOdontologo(odontologo1);
        Domicilio domicilio1 = domicilioService.obtenerDomicilioPorId(1L);
        paciente1.setDomicilio(domicilio1);
//        Turno turno1 = turnoService.obtenerTurnoPorId(1L);
//        paciente1.setTurno(turno1);
        crearPaciente(paciente1);

        // Paciente 2
        Paciente paciente2 = new Paciente();
        paciente2.setNombre("María");
        paciente2.setApellido("López");
        paciente2.setFechaIngreso(LocalDate.now()); // Agregar la fecha actual como fecha de ingreso
        paciente2.setDni("87654321"); // Agregar el número de documento (dni)
//        Odontologo odontologo2 = odontologoService.obtenerOdontologoPorId(2L);
//        paciente2.setOdontologo(odontologo2);
        Domicilio domicilio2 = domicilioService.obtenerDomicilioPorId(2L);
        paciente2.setDomicilio(domicilio2);
//        Turno turno2 = turnoService.obtenerTurnoPorId(2L);
//        paciente2.setTurno(turno2);
        crearPaciente(paciente2);

        // Paciente 3
        Paciente paciente3 = new Paciente();
        paciente3.setNombre("Laura");
        paciente3.setApellido("Gómez");
        paciente3.setFechaIngreso(LocalDate.now()); // Agregar la fecha actual como fecha de ingreso
        paciente3.setDni("54321678"); // Agregar el número de documento (dni)
//        Odontologo odontologo3 = odontologoService.obtenerOdontologoPorId(3L);
//        paciente3.setOdontologo(odontologo3);
        Domicilio domicilio3 = domicilioService.obtenerDomicilioPorId(3L);
        paciente3.setDomicilio(domicilio3);
//        Turno turno3 = turnoService.obtenerTurnoPorId(3L);
//        paciente3.setTurno(turno3);
        crearPaciente(paciente3);
    }



}
