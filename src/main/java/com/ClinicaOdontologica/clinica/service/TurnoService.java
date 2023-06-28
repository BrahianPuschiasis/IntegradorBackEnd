package com.ClinicaOdontologica.clinica.service;


import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.ClinicaOdontologica.clinica.model.entity.Turno;
import com.ClinicaOdontologica.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    ITurnoRepository iTurnoRepository;
    @Autowired
    OdontologoService odontologoService;
    @Autowired
    PacienteService pacienteService;

    public Collection<Turno> traerTodos() {
        return iTurnoRepository.findAll();

    }

    public void crearTurno(Turno turno) {
        iTurnoRepository.save(turno);

    }

    public void modificarTurno(Turno turno) {
        iTurnoRepository.save(turno);
    }

    public void eliminarTurno(Long id) {
        Optional<Turno> turnoOptional = iTurnoRepository.findById(id);
        if (turnoOptional.isPresent()) {
            Turno turno = turnoOptional.get();
            iTurnoRepository.delete(turno);
        } else {
            throw new RuntimeException("No se encontró el turno con ID: " + id);
        }
    }

    public Turno obtenerTurnoPorId(Long id) {
        Optional<Turno> turnoOptional = iTurnoRepository.findById(id);
        return turnoOptional.orElseThrow(() -> new RuntimeException("No se encontró el turno con ID: " + id));
    }

    public void cargarDatosDePrueba() {
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

        Turno turno2 = new Turno();
        turno2.setFechaHora(LocalDateTime.of(2023, 6, 20, 12, 30));
        turno2.setOdontologo(odontologo2);
        turno2.setPaciente(paciente2);
        iTurnoRepository.save(turno2);

        Turno turno3 = new Turno();
        turno3.setFechaHora(LocalDateTime.of(2023, 6, 20, 13, 30));
        turno3.setOdontologo(odontologo1);
        turno3.setPaciente(paciente3);
        iTurnoRepository.save(turno3);

        Turno turno4 = new Turno();
        turno4.setFechaHora(LocalDateTime.of(2023, 6, 20, 14, 30));
        turno4.setOdontologo(odontologo1);
        turno4.setPaciente(paciente2);
        iTurnoRepository.save(turno4);

        Turno turno5 = new Turno();
        turno5.setFechaHora(LocalDateTime.of(2023, 6, 20, 15, 30));
        turno5.setOdontologo(odontologo3);
        turno5.setPaciente(paciente3);
        iTurnoRepository.save(turno5);
    }




}
