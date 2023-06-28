package com.ClinicaOdontologica.clinica.repository;

import com.ClinicaOdontologica.clinica.model.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {

}
