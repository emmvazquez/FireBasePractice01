package com.practica.firebasepractice01;

public class Estudiante {

    public String idEstudiante;
    public String nombre;
    public String apellidos;
    public String sexo;
    public String carrera;

    public Estudiante(String idEstudiante, String nombre, String apellidos, String sexo, String carrera) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.carrera = carrera;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCarrera() {
        return carrera;
    }
}
