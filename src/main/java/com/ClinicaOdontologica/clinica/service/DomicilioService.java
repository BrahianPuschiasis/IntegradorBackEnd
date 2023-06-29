package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.model.entity.Domicilio;
import com.ClinicaOdontologica.clinica.repository.IDomicilioRepository;
import com.ClinicaOdontologica.clinica.service.impl.IDomicilioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService {

    private static final Logger logger = Logger.getLogger(DomicilioService.class);

    @Autowired
    IDomicilioRepository iDomicilioRepository;



    @Override
    public List<Domicilio> traerTodos() {
        try {
            List<Domicilio> domicilios = iDomicilioRepository.findAll();
            logger.info("La lista de domicilios se trajo correctamente");
            return domicilios;
        } catch (Exception ex) {
            logger.error("No se pudo traer la lista de domicilios", ex);
            throw new RuntimeException("Error al traer la lista de domicilios", ex);
        }
    }

    @Override
    public void crearDomicilio(Domicilio domicilio) {
        try {
            iDomicilioRepository.save(domicilio);
            logger.info("Se creó correctamente el domicilio con ID: " + domicilio.getId());
        } catch (Exception ex) {
            logger.error("No se pudo crear el domicilio", ex);
            throw new RuntimeException("Error al crear el domicilio", ex);
        }
    }

    @Override
    public void modificarDomicilio(Domicilio domicilio) {
        try {
            iDomicilioRepository.save(domicilio);
            logger.info("Se modificó correctamente el domicilio con ID: " + domicilio.getId());
        } catch (Exception ex) {
            logger.error("No se pudo modificar el domicilio", ex);
            throw new RuntimeException("Error al modificar el domicilio", ex);
        }
    }

    @Override
    public void eliminarDomicilio(Long id) {
        try {
            iDomicilioRepository.deleteById(id);
            logger.info("Se eliminó correctamente el domicilio con ID: " + id);
        } catch (Exception ex) {
            logger.error("No se pudo eliminar el domicilio con ID: " + id, ex);
            throw new RuntimeException("Error al eliminar el domicilio con ID: " + id, ex);
        }
    }

    public void cargarDatosDePrueba() {
        try {
            Domicilio domicilio1 = new Domicilio();
            domicilio1.setCalle("Calle 1");
            domicilio1.setNumero(123);
            domicilio1.setLocalidad("Localidad 1");
            domicilio1.setProvincia("Provincia 1");
            iDomicilioRepository.save(domicilio1);
            logger.info("Se creó correctamente el domicilio con ID: " + domicilio1.getId());

            Domicilio domicilio2 = new Domicilio();
            domicilio2.setCalle("Calle 2");
            domicilio2.setNumero(456);
            domicilio2.setLocalidad("Localidad 2");
            domicilio2.setProvincia("Provincia 2");
            iDomicilioRepository.save(domicilio2);
            logger.info("Se creó correctamente el domicilio con ID: " + domicilio2.getId());

            Domicilio domicilio3 = new Domicilio();
            domicilio3.setCalle("Calle 3");
            domicilio3.setNumero(789);
            domicilio3.setLocalidad("Localidad 3");
            domicilio3.setProvincia("Provincia 3");
            iDomicilioRepository.save(domicilio3);
            logger.info("Se creó correctamente el domicilio con ID: " + domicilio3.getId());

            Domicilio domicilio4 = new Domicilio();
            domicilio4.setCalle("Calle 4");
            domicilio4.setNumero(1011);
            domicilio4.setLocalidad("Localidad 4");
            domicilio4.setProvincia("Provincia 4");
            iDomicilioRepository.save(domicilio4);
            logger.info("Se creó correctamente el domicilio con ID: " + domicilio4.getId());

            Domicilio domicilio5 = new Domicilio();
            domicilio5.setCalle("Calle 5");
            domicilio5.setNumero(1213);
            domicilio5.setLocalidad("Localidad 5");
            domicilio5.setProvincia("Provincia 5");
            iDomicilioRepository.save(domicilio5);
            logger.info("Se creó correctamente el domicilio con ID: " + domicilio5.getId());
        } catch (Exception ex) {
            logger.error("Error al cargar los datos de prueba de domicilios", ex);
            throw new RuntimeException("Error al cargar los datos de prueba de domicilios", ex);
        }
    }

    @Override
    public Domicilio obtenerDomicilioPorId(Long id) {
        try {
            Optional<Domicilio> domicilioOptional = iDomicilioRepository.findById(id);
            return domicilioOptional.orElseThrow(() -> new RuntimeException("No se encontró el domicilio con ID: " + id));
        } catch (Exception ex) {
            logger.error("No se pudo obtener el domicilio con ID: " + id, ex);
            throw new RuntimeException("Error al obtener el domicilio con ID: " + id, ex);
        }
    }



}
