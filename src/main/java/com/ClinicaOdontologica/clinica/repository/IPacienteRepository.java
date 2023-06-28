package com.ClinicaOdontologica.clinica.repository;

import com.ClinicaOdontologica.clinica.entity.Paciente;
import com.ClinicaOdontologica.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {



}
