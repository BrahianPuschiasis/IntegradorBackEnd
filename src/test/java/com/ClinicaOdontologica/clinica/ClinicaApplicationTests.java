package com.ClinicaOdontologica.clinica;

import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.service.impl.IOdontologoService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class ClinicaApplicationTests {

	@Autowired
	IOdontologoService odontologoService;

//	@BeforeEach
//	public void cargarDatos(){
//
//		deje el codigo aca para que se entienda que se usar un beforEach, el tema es que preferi hacerlo local nada mas
//		porque solo hice un testeo como se sugirio
//
//		Odontologo odontologo1 = new Odontologo();
//		odontologo1.setApellido("Cristian");
//		odontologo1.setNombre("Miguel");
//		odontologo1.setMatricula("123456");
//		odontologoService.crearOdontologo(odontologo1);
//	}

	@Test
	public void testOdontologos(){

		//solo hice de odontologo porque se entiende que es practicamente lo mismo para el resto, y en teoria se pedia solo uno para que sastifasa la nota del test


		// creo un odontologo de prueba especifico para todos los test de odontologos
		Odontologo odontologo2 = new Odontologo();
		odontologo2.setApellido("Brahian");
		odontologo2.setNombre("Daniel");
		odontologo2.setMatricula("5346259");
		odontologoService.crearOdontologo(odontologo2);

		//pruebo no solo si funciona el buscar odontologo, si no que tambien el crearlo
		Odontologo  odontologo = odontologoService.obtenerOdontologoPorId(1l);
		Assert.assertNotNull(odontologo);



		// Modificar los datos del odontólogo
		odontologo2.setApellido("Ruperto");
		odontologo2.setNombre("DelToro");
		odontologo2.setMatricula("123123");
		odontologoService.modificarOdontologo(odontologo2);

		// Obtener el odontólogo modificado
		Odontologo odontologoModificado = odontologoService.obtenerOdontologoPorId(1L);
		Assert.assertEquals("Ruperto", odontologoModificado.getApellido());
		Assert.assertEquals("DelToro", odontologoModificado.getNombre());
		Assert.assertEquals("123123", odontologoModificado.getMatricula());


		// Pruebo si funciona eliminar odontólogo, al mismo tiempo que se testea si listarlos funciona
		odontologoService.eliminarOdontologo(1L);
		if (!odontologoService.traerTodos().isEmpty()) {
			throw new AssertionError("La lista de odontólogos no está vacía después de eliminar un odontólogo");
		}



	}



}
