package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.model.entity.Paciente;
import com.ClinicaOdontologica.clinica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    IOdontologoRepository iOdontologoRepository;

    public Collection<Odontologo> traerTodos() {
        return iOdontologoRepository.findAll();

    }


    public Odontologo obtenerOdontologoPorId(Long id) {
        Optional<Odontologo> odontologoOptional = iOdontologoRepository.findById(id);
        return odontologoOptional.orElseThrow(() -> new RuntimeException("No se encontró el odontólogo con ID: " + id));
    }
    public void crearOdontologo(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);

    }

    public void modificarOdontologo(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    public void eliminarOdontologo(Long id) {
        Optional<Odontologo> odontologoOptional = iOdontologoRepository.findById(id);
        if (odontologoOptional.isPresent()) {
            Odontologo odontologo = odontologoOptional.get();
            iOdontologoRepository.delete(odontologo);
        } else {
            throw new RuntimeException("No se encontró el odontólogo con ID: " + id);
        }
    }

    public void cargarDatosDePrueba() {



        Odontologo odontologo1 = new Odontologo();
        odontologo1.setApellido("Pérez");
        odontologo1.setNombre("Juan");
        odontologo1.setMatricula("12345");
        crearOdontologo(odontologo1);


        Odontologo odontologo2 = new Odontologo();
        odontologo2.setApellido("López");
        odontologo2.setNombre("María");
        odontologo2.setMatricula("54321");
        crearOdontologo(odontologo2);

        Odontologo odontologo3 = new Odontologo();
        odontologo3.setApellido("Gómez");
        odontologo3.setNombre("Laura");
        odontologo3.setMatricula("67890");
        crearOdontologo(odontologo3);

        Odontologo odontologo4 = new Odontologo();
        odontologo4.setApellido("Martínez");
        odontologo4.setNombre("Carlos");
        odontologo4.setMatricula("09876");
        crearOdontologo(odontologo4);

        Odontologo odontologo5 = new Odontologo();
        odontologo5.setApellido("Fernández");
        odontologo5.setNombre("Ana");
        odontologo5.setMatricula("45678");
        crearOdontologo(odontologo5);

        this.modificarOdontologo(odontologo1);
        this.modificarOdontologo(odontologo2);
        this.modificarOdontologo(odontologo3);
        this.modificarOdontologo(odontologo4);
        this.modificarOdontologo(odontologo5);


    }


}
