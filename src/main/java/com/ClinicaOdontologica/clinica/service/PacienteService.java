package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.model.entity.Domicilio;
import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.ClinicaOdontologica.clinica.repository.IPacienteRepository;
import com.ClinicaOdontologica.clinica.service.impl.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    OdontologoService odontologoService;

    @Autowired
    DomicilioService domicilioService;

    @Autowired
    TurnoService turnoService;


    @Override
    public Collection<Paciente> traerTodos() {
        try {
            return iPacienteRepository.findAll();
        } catch (Exception ex) {
            logger.error("Error al obtener todos los pacientes", ex);
            throw new RuntimeException("Error al obtener todos los pacientes", ex);
        }
    }

    @Override
    public void crearPaciente(Paciente paciente) {
        try {
            iPacienteRepository.save(paciente);
            logger.info("Se creó correctamente el paciente: " + paciente.getNombre() + " " + paciente.getApellido());
        } catch (Exception ex) {
            logger.error("Error al crear el paciente: " + paciente.getNombre() + " " + paciente.getApellido(), ex);
            throw new RuntimeException("Error al crear el paciente: " + paciente.getNombre() + " " + paciente.getApellido(), ex);
        }
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
        try {
            iPacienteRepository.save(paciente);
            logger.info("Se modificó correctamente el paciente con ID: " + paciente.getId());
        } catch (Exception ex) {
            logger.error("Error al modificar el paciente con ID: " + paciente.getId(), ex);
            throw new RuntimeException("Error al modificar el paciente con ID: " + paciente.getId(), ex);
        }
    }

    @Override
    public void eliminarPaciente(Long id) {
        try {
            Optional<Paciente> pacienteOptional = iPacienteRepository.findById(id);
            if (pacienteOptional.isPresent()) {
                Paciente paciente = pacienteOptional.get();
                iPacienteRepository.delete(paciente);
                logger.info("Se eliminó correctamente el paciente con ID: " + id);
            } else {
                logger.error("No se encontró el paciente con ID: " + id);
                throw new RuntimeException("No se encontró el paciente con ID: " + id);
            }
        } catch (Exception ex) {
            logger.error("Error al eliminar el paciente con ID: " + id, ex);
            throw new RuntimeException("Error al eliminar el paciente con ID: " + id, ex);
        }
    }

    @Override
    public Paciente obtenerPacientePorId(Long id) {
        try {
            Optional<Paciente> pacienteOptional = iPacienteRepository.findById(id);
            return pacienteOptional.orElseThrow(() -> {
                logger.error("No se encontró el paciente con ID: " + id);
                return new RuntimeException("No se encontró el paciente con ID: " + id);
            });
        } catch (Exception ex) {
            logger.error("Error al obtener el paciente con ID: " + id, ex);
            throw new RuntimeException("Error al obtener el paciente con ID: " + id, ex);
        }
    }

    public void cargarDatosDePrueba() {
        try {
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

            logger.info("Se cargaron correctamente los datos de prueba para pacientes");
        } catch (Exception ex) {
            logger.error("Error al cargar los datos de prueba para pacientes", ex);
            throw new RuntimeException("Error al cargar los datos de prueba para pacientes", ex);
        }
    }




}
