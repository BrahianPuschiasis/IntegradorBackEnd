package com.ClinicaOdontologica.clinica.service.interfaces;

import com.ClinicaOdontologica.clinica.model.entity.Domicilio;

import java.util.Collection;

public interface IDomicilioService {
    void crearDomicilio(Domicilio domicilio);
    void modificarDomicilio(Domicilio domicilio);
    void eliminarDomicilio(Long id);
    Collection<Domicilio> traerTodos();
    Domicilio obtenerDomicilioPorId(Long id);
}
