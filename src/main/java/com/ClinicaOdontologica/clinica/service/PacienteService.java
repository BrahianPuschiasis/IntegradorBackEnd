package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.model.entity.Domicilio;
import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.ClinicaOdontologica.clinica.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
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
        Domicilio domicilio1 = domicilioService.obtenerDomicilioPorId(1L);
        paciente1.setDomicilio(domicilio1);
        crearPaciente(paciente1);

        // Paciente 2
        Paciente paciente2 = new Paciente();
        paciente2.setNombre("María");
        paciente2.setApellido("López");
        paciente2.setFechaIngreso(LocalDate.now()); // Agregar la fecha actual como fecha de ingreso
        paciente2.setDni("87654321"); // Agregar el número de documento (dni)
        Domicilio domicilio2 = domicilioService.obtenerDomicilioPorId(2L);
        paciente2.setDomicilio(domicilio2);
        crearPaciente(paciente2);

        // Paciente 3
        Paciente paciente3 = new Paciente();
        paciente3.setNombre("Laura");
        paciente3.setApellido("Gómez");
        paciente3.setFechaIngreso(LocalDate.now()); // Agregar la fecha actual como fecha de ingreso
        paciente3.setDni("54321678"); // Agregar el número de documento (dni)
        Domicilio domicilio3 = domicilioService.obtenerDomicilioPorId(3L);
        paciente3.setDomicilio(domicilio3);
        crearPaciente(paciente3);
    }



}
