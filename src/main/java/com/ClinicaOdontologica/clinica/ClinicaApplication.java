package com.ClinicaOdontologica.clinica;

import com.ClinicaOdontologica.clinica.service.DomicilioService;
import com.ClinicaOdontologica.clinica.service.OdontologoService;
import com.ClinicaOdontologica.clinica.service.PacienteService;
import com.ClinicaOdontologica.clinica.service.TurnoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ClinicaApplication.class, args);

		OdontologoService odontologoService = context.getBean(OdontologoService.class);
		odontologoService.cargarDatosDePrueba();

		DomicilioService domicilioService = context.getBean(DomicilioService.class);
		domicilioService.cargarDatosDePrueba();


		PacienteService pacienteService = context.getBean(PacienteService.class);
		pacienteService.cargarDatosDePrueba();

		TurnoService turnoService = context.getBean(TurnoService.class);
		turnoService.cargarDatosDePrueba();


	}
}