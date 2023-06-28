package com.ClinicaOdontologica.clinica.model.dto;

import com.ClinicaOdontologica.clinica.model.entity.Domicilio;
import com.ClinicaOdontologica.clinica.model.entity.Turno;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.Set;

public class PacienteDTO {

    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private String dni;
    private LocalDate fechaIngreso;

}
