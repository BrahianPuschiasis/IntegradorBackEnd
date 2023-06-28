package com.ClinicaOdontologica.clinica.repository;

import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {

}
