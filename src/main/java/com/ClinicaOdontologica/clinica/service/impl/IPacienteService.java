package com.ClinicaOdontologica.clinica.service.impl;

import com.ClinicaOdontologica.clinica.model.entity.Paciente;

import java.util.Collection;

public interface IPacienteService {
    void crearPaciente(Paciente paciente);
    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Collection<Paciente> traerTodos();
    Paciente obtenerPacientePorId(Long id);
}
