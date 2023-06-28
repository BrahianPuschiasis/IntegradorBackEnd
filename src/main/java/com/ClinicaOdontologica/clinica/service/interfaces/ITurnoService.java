package com.ClinicaOdontologica.clinica.service.interfaces;
import com.ClinicaOdontologica.clinica.model.entity.Turno;

import java.util.Collection;

public interface ITurnoService {
    void crearTurno(Turno turno);
    void modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    Collection<Turno> traerTodos();
    Turno obtenerTurnoPorId(Long id);
}
