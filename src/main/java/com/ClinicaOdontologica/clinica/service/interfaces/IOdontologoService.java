package com.ClinicaOdontologica.clinica.service.interfaces;

import com.ClinicaOdontologica.clinica.model.dto.OdontologoDTO;
import com.ClinicaOdontologica.clinica.model.entity.Odontologo;

import java.util.Collection;

public interface IOdontologoService {

    void crearOdontologo(Odontologo odontologo);
    void modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    Collection<OdontologoDTO> traerTodos();
    Odontologo obtenerOdontologoPorId(Long id);


}
