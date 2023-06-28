package com.ClinicaOdontologica.clinica.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    @ManyToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
    private String dni;
    private LocalDate fechaIngreso;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;


//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "odontologo_id", nullable = false)
//    private Odontologo odontologo;
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "turno_id", nullable = false)
//    private Turno turno;

    public Paciente() {
    }


    public Paciente(String nombre, String apellido, Domicilio domicilio, String dni, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }

    public Paciente(String nombre, String apellido, Domicilio domicilio, String dni, LocalDate fechaIngreso, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.turnos = turnos;
    }

    //    public Paciente(Long id, String nombre, String apellido, Domicilio domicilio, String dni, LocalDate fechaIngreso, Odontologo odontologo, Turno turno) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.domicilio = domicilio;
//        this.dni = dni;
//        this.fechaIngreso = fechaIngreso;
//        this.odontologo = odontologo;
//        this.turno = turno;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

//    public Odontologo getOdontologo() {
//        return odontologo;
//    }

//    public void setOdontologo(Odontologo odontologo) {
//        this.odontologo = odontologo;
//    }
//
//    public Turno getTurno() {
//        return turno;
//    }
//
//    public void setTurno(Turno turno) {
//        this.turno = turno;
//    }
}
