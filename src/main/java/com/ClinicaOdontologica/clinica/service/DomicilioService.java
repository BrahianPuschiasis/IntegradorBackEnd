package com.ClinicaOdontologica.clinica.service;

import com.ClinicaOdontologica.clinica.entity.Domicilio;
import com.ClinicaOdontologica.clinica.entity.Turno;
import com.ClinicaOdontologica.clinica.repository.IDomicilioRepository;
import com.ClinicaOdontologica.clinica.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    IDomicilioRepository iDomicilioRepository;

    public List<Domicilio> traerTodos() {
        return iDomicilioRepository.findAll();

    }

    public void crearDomicilio(Domicilio domicilio) {
        iDomicilioRepository.save(domicilio);

    }

    public void modificarDomicilio(Domicilio domicilio) {
        iDomicilioRepository.save(domicilio);
    }

    public void eliminarDomicilio(Long id) {
        iDomicilioRepository.deleteById(id);
    }

    public void cargarDatosDePrueba() {
        Domicilio domicilio1 = new Domicilio();
        domicilio1.setCalle("Calle 1");
        domicilio1.setNumero(123);
        domicilio1.setLocalidad("Localidad 1");
        domicilio1.setProvincia("Provincia 1");
        iDomicilioRepository.save(domicilio1);

        Domicilio domicilio2 = new Domicilio();
        domicilio2.setCalle("Calle 2");
        domicilio2.setNumero(456);
        domicilio2.setLocalidad("Localidad 2");
        domicilio2.setProvincia("Provincia 2");
        iDomicilioRepository.save(domicilio2);

        Domicilio domicilio3 = new Domicilio();
        domicilio3.setCalle("Calle 3");
        domicilio3.setNumero(789);
        domicilio3.setLocalidad("Localidad 3");
        domicilio3.setProvincia("Provincia 3");
        iDomicilioRepository.save(domicilio3);

        Domicilio domicilio4 = new Domicilio();
        domicilio4.setCalle("Calle 4");
        domicilio4.setNumero(1011);
        domicilio4.setLocalidad("Localidad 4");
        domicilio4.setProvincia("Provincia 4");
        iDomicilioRepository.save(domicilio4);

        Domicilio domicilio5 = new Domicilio();
        domicilio5.setCalle("Calle 5");
        domicilio5.setNumero(1213);
        domicilio5.setLocalidad("Localidad 5");
        domicilio5.setProvincia("Provincia 5");
        iDomicilioRepository.save(domicilio5);
    }
    public Domicilio obtenerDomicilioPorId(Long id) {
        Optional<Domicilio> domicilioOptional = iDomicilioRepository.findById(id);
        return domicilioOptional.orElseThrow(() -> new RuntimeException("No se encontró el domicilio con ID: " + id));
    }


}
