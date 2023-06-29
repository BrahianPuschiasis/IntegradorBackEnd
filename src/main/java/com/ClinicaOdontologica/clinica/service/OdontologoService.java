package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.model.dto.OdontologoDTO;
import com.ClinicaOdontologica.clinica.model.entity.Odontologo;
import com.ClinicaOdontologica.clinica.repository.IOdontologoRepository;
import com.ClinicaOdontologica.clinica.service.impl.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {
    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Collection<OdontologoDTO> traerTodos() {
        try {
            Collection<Odontologo> allOdontologos = iOdontologoRepository.findAll();
            Set<OdontologoDTO> allOdontologosDTO = allOdontologos.stream()
                    .map(odontologo -> mapper.convertValue(odontologo, OdontologoDTO.class))
                    .sorted(Comparator.comparingLong(OdontologoDTO::getId))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            logger.info("La lista de odontólogos se trajo correctamente");

            return allOdontologosDTO;
        } catch (Exception ex) {
            logger.error("No se pudo traer la lista de odontólogos", ex);
            throw new RuntimeException("Error al traer la lista de odontólogos", ex);
        }
    }



    @Override
    public Odontologo obtenerOdontologoPorId(Long id) {
        try {
            Optional<Odontologo> odontologoOptional = iOdontologoRepository.findById(id);
            return odontologoOptional.orElseThrow(() -> {
                logger.error("No se encontró el odontólogo con ID: " + id);
                return new RuntimeException("No se encontró el odontólogo con ID: " + id);
            });
        } catch (Exception ex) {
            logger.error("Error al obtener el odontólogo con ID: " + id, ex);
            throw new RuntimeException("Error al obtener el odontólogo con ID: " + id, ex);
        }
    }

    @Override
    public void crearOdontologo(Odontologo odontologo) {
        try {
            iOdontologoRepository.save(odontologo);
            logger.info("Se creó correctamente el odontólogo: " + odontologo.getNombre() + " " + odontologo.getApellido());
        } catch (Exception ex) {
            logger.error("Error al crear el odontólogo: " + odontologo.getNombre() + " " + odontologo.getApellido(), ex);
            throw new RuntimeException("Error al crear el odontólogo: " + odontologo.getNombre() + " " + odontologo.getApellido(), ex);
        }
    }

    @Override
    public void modificarOdontologo(Odontologo odontologo) {
        try {
            iOdontologoRepository.save(odontologo);
            logger.info("Se modificó correctamente el odontólogo con ID: " + odontologo.getId());
        } catch (Exception ex) {
            logger.error("Error al modificar el odontólogo con ID: " + odontologo.getId(), ex);
            throw new RuntimeException("Error al modificar el odontólogo con ID: " + odontologo.getId(), ex);
        }
    }

    @Override
    public void eliminarOdontologo(Long id) {
        try {
            Optional<Odontologo> odontologoOptional = iOdontologoRepository.findById(id);
            if (odontologoOptional.isPresent()) {
                Odontologo odontologo = odontologoOptional.get();
                iOdontologoRepository.delete(odontologo);
                logger.info("Se eliminó correctamente el odontólogo con ID: " + id);
            } else {
                logger.error("No se encontró el odontólogo con ID: " + id);
                throw new RuntimeException("No se encontró el odontólogo con ID: " + id);
            }
        } catch (Exception ex) {
            logger.error("Error al eliminar el odontólogo con ID: " + id, ex);
            throw new RuntimeException("Error al eliminar el odontólogo con ID: " + id, ex);
        }
    }

    public void cargarDatosDePrueba() {
        try {
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
            logger.info("Se cargaron correctamente los datos de prueba");
        } catch (Exception ex) {
            logger.error("Error al cargar los datos de prueba", ex);
            throw new RuntimeException("Error al cargar los datos de prueba", ex);
        }
    }



}
