package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.model.dto.OdontologoDTO;
import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.repository.IOdontologoRepository;
import com.ClinicaOdontologica.clinica.service.impl.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Collection<OdontologoDTO> traerTodos() {
        Collection<Odontologo> allOdontologos = iOdontologoRepository.findAll();
        Set<OdontologoDTO> allOdontologosDTO = allOdontologos.stream()
                .map(odontologo -> mapper.convertValue(odontologo, OdontologoDTO.class))
                .sorted(Comparator.comparingLong(OdontologoDTO::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return allOdontologosDTO;
    }



    @Override
    public Odontologo obtenerOdontologoPorId(Long id) {
        Optional<Odontologo> odontologoOptional = iOdontologoRepository.findById(id);
        return odontologoOptional.orElseThrow(() -> new RuntimeException("No se encontró el odontólogo con ID: " + id));
    }
    @Override
    public void crearOdontologo(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);

    }
    @Override
    public void modificarOdontologo(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    @Override
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
