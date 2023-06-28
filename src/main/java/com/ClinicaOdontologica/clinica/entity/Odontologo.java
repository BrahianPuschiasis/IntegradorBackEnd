package com.ClinicaOdontologica.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Odontologo {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String apellido;
    private String nombre;
    private String matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;




//    @OneToMany(mappedBy = "odontologo")
//    @JsonIgnore
//    private List<Paciente> pacientes;
    public Odontologo() {
    }


    public Odontologo(String apellido, String nombre, String matricula, Set<Turno> turnos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        this.turnos = turnos;
    }

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }


    //    public List<Paciente> getPacientes() {
//        return pacientes;
//    }

//    public void setPacientes(List<Paciente> pacientes) {
//        this.pacientes = pacientes;
//    }
//
//    public Odontologo(Long id, String apellido, String nombre, String matricula, List<Paciente> pacientes) {
//        this.id = id;
//        this.apellido = apellido;
//        this.nombre = nombre;
//        this.matricula = matricula;
//        this.pacientes = pacientes;
//    }

    public Odontologo(Long id, String apellido, String nombre, String matricula) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
