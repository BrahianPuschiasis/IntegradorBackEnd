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

		//https://github.com/BrahianPuschiasis/IntegradorBackEnd

		//demore en implementar log4j, e incluso github pero estan practicamente todos los commit/uploads de las cosas mas importantes

		//uso cargarDatosDePrueba para cada entidad, asi no comienza de cero y es más facil visualizarlo/navegar, funciona el BAM al 100%
		//tanto en front como por postman/base de datos, las credenciales del login estan en DataLoader, con un user y admin
		//para acceder a la aplicacion basta con poner en el navegador "http://localhost:8080/", si se accede directamente a los html en Static
		//no va a funcionar, lo pude hacer andar asi con una anotacion pero preferi dejarlo por localhost8080

		//los logs estan en resources, iba a crearle un package "logs" pero no estaba seguro si estaba bien, esta implementado en los services
		// de turno odontologo, domicilio y paciente, en dto solo use para listar en odontologo para que se entienda que se usarlo, como se dijo
		//que no era necesario y en caso de hacerlo que sea en listar nomas hice eso

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