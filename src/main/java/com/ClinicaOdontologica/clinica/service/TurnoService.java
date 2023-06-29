package com.ClinicaOdontologica.clinica.service;


import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.ClinicaOdontologica.clinica.model.entity.Turno;
import com.ClinicaOdontologica.clinica.repository.ITurnoRepository;
import com.ClinicaOdontologica.clinica.service.impl.ITurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    private static final Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    ITurnoRepository iTurnoRepository;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    PacienteService pacienteService;

    @Override
    public Collection<Turno> traerTodos() {
        try {
            return iTurnoRepository.findAll();
        } catch (Exception ex) {
            logger.error("No se pudo traer la lista de turnos", ex);
            throw new RuntimeException("Error al traer la lista de turnos", ex);
        }
    }

    @Override
    public void crearTurno(Turno turno) {
        try {
            iTurnoRepository.save(turno);
            logger.info("Se creó correctamente el turno con ID: " + turno.getId());
        } catch (Exception ex) {
            logger.error("No se pudo crear el turno", ex);
            throw new RuntimeException("Error al crear el turno", ex);
        }
    }

    @Override
    public void modificarTurno(Turno turno) {
        try {
            iTurnoRepository.save(turno);
            logger.info("Se modificó correctamente el turno con ID: " + turno.getId());
        } catch (Exception ex) {
            logger.error("No se pudo modificar el turno", ex);
            throw new RuntimeException("Error al modificar el turno", ex);
        }
    }

    @Override
    public void eliminarTurno(Long id) {
        try {
            Optional<Turno> turnoOptional = iTurnoRepository.findById(id);
            if (turnoOptional.isPresent()) {
                Turno turno = turnoOptional.get();
                iTurnoRepository.delete(turno);
                logger.info("Se eliminó correctamente el turno con ID: " + id);
            } else {
                throw new RuntimeException("No se encontró el turno con ID: " + id);
            }
        } catch (Exception ex) {
            logger.error("No se pudo eliminar el turno con ID: " + id, ex);
            throw new RuntimeException("Error al eliminar el turno con ID: " + id, ex);
        }
    }

    @Override
    public Turno obtenerTurnoPorId(Long id) {
        try {
            Optional<Turno> turnoOptional = iTurnoRepository.findById(id);
            return turnoOptional.orElseThrow(() -> new RuntimeException("No se encontró el turno con ID: " + id));
        } catch (Exception ex) {
            logger.error("No se pudo obtener el turno con ID: " + id, ex);
            throw new RuntimeException("Error al obtener el turno con ID: " + id, ex);
        }
    }

    public void cargarDatosDePrueba() {
        try {
            Odontologo odontologo1 = odontologoService.obtenerOdontologoPorId(1L);
            Odontologo odontologo2 = odontologoService.obtenerOdontologoPorId(2L);
            Odontologo odontologo3 = odontologoService.obtenerOdontologoPorId(3L);

            Paciente paciente1 = pacienteService.obtenerPacientePorId(1L);
            Paciente paciente2 = pacienteService.obtenerPacientePorId(2L);
            Paciente paciente3 = pacienteService.obtenerPacientePorId(3L);

            Turno turno1 = new Turno();
            turno1.setFechaHora(LocalDateTime.of(2023, 6, 20, 11, 30));
            turno1.setOdontologo(odontologo1);
            turno1.setPaciente(paciente1);
            iTurnoRepository.save(turno1);
            logger.info("Se creó correctamente el turno con ID: " + turno1.getId());

            Turno turno2 = new Turno();
            turno2.setFechaHora(LocalDateTime.of(2023, 6, 20, 12, 30));
            turno2.setOdontologo(odontologo2);
            turno2.setPaciente(paciente2);
            iTurnoRepository.save(turno2);
            logger.info("Se creó correctamente el turno con ID: " + turno2.getId());

            Turno turno3 = new Turno();
            turno3.setFechaHora(LocalDateTime.of(2023, 6, 20, 13, 30));
            turno3.setOdontologo(odontologo1);
            turno3.setPaciente(paciente3);
            iTurnoRepository.save(turno3);
            logger.info("Se creó correctamente el turno con ID: " + turno3.getId());

            Turno turno4 = new Turno();
            turno4.setFechaHora(LocalDateTime.of(2023, 6, 20, 14, 30));
            turno4.setOdontologo(odontologo1);
            turno4.setPaciente(paciente2);
            iTurnoRepository.save(turno4);
            logger.info("Se creó correctamente el turno con ID: " + turno4.getId());

            Turno turno5 = new Turno();
            turno5.setFechaHora(LocalDateTime.of(2023, 6, 20, 15, 30));
            turno5.setOdontologo(odontologo3);
            turno5.setPaciente(paciente3);
            iTurnoRepository.save(turno5);
            logger.info("Se creó correctamente el turno con ID: " + turno5.getId());
        } catch (Exception ex) {
            logger.error("Error al cargar los datos de prueba de turnos", ex);
            throw new RuntimeException("Error al cargar los datos de prueba de turnos", ex);
        }
    }





}
