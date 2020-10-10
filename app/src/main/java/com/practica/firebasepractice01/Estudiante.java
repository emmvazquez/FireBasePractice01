package com.practica.firebasepractice01;

public class Estudiante {

    public String IdEstudiante;
    public String Nombre;
    public String Apellidos;
    public String Sexo;
    public String Carrera;

    public Estudiante(String idEstudiante, String nombre, String apellidos, String sexo, String carrera) {
        IdEstudiante = idEstudiante;
        Nombre = nombre;
        Apellidos = apellidos;
        Sexo = sexo;
        Carrera = carrera;
    }

    public String getIdEstudiante() {
        return IdEstudiante;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getCarrera() {
        return Carrera;
    }
}
