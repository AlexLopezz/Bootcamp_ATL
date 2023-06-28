package Excercise1.models;

import java.time.LocalDate;

public class Persona {
    private int id, edad;
    private String nombre, DNI;
    private LocalDate fechaNacimiento;

    public Persona() {
    }

    public Persona(int id, int edad, String nombre, String DNI, LocalDate fechaNacimiento) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public boolean esMayorEdad() {
        return edad > 18;
    }
    public void mostrar(){
        System.out.println("ID: "+ getId()+
                "\nNombre: "+getNombre()+
                "\nDNI: "+getDNI()+
                "\nEdad: "+ getEdad()+
                "\nFecha nacimiento: "+ getFechaNacimiento());
    }
}
