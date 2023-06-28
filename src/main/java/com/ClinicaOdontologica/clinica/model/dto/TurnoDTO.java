package com.ClinicaOdontologica.clinica.model.dto;

import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class TurnoDTO {

    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDateTime fechaHora;

}
