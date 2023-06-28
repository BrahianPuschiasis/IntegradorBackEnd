package com.ClinicaOdontologica.clinica.model.dto;

import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class DomicilioDTO {


    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

}
