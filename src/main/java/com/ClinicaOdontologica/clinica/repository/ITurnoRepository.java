package com.ClinicaOdontologica.clinica.repository;


import com.ClinicaOdontologica.clinica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
