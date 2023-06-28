package com.ClinicaOdontologica.clinica.model.dto;

import com.ClinicaOdontologica.clinica.model.entity.Turno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class OdontologoDTO {

    private String apellido;
    private String nombre;
    private String matricula;

}
