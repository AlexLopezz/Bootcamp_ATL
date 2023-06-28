package Excercise1;

import Excercise1.models.Cuenta;
import Excercise1.models.Persona;

import java.time.LocalDate;

/*
Ejercicio 1 y 2:
1) Vamos a crear una clase llamada Persona, sus atributos son:
    * id
    * nombre
    * edad
    * fecha de nacimiento
    * DNI.
Construye los siguientes métodos para la clase:
    * Un constructor, donde los datos pueden estar vacíos.
    * Los setters y getters para cada uno de los atributos.
    * mostrar(): Muestra los datos de la persona.
    * esMayorDeEdad(): Devuelve un valor lógico indicando si es mayor de edad.

2) Crear una clase llamada Cuenta que tendrá los siguientes atributos:
    * titular (que es una persona)
    * cantidad (puede tener decimales).
Construye los siguientes métodos para la clase:
    * Un constructor, donde los datos pueden estar vacíos.
    * Los setters y getters para cada uno de los atributos. El atributo no se puede modificar directamente, sólo ingresando o retirando dinero.
    * mostrar(): Muestra los datos de la cuenta.
    * ingresar(cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
    * retirar(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en números rojos.
 */
public class Main {
    public static void main(String[] args) {
        ejercicio1();
        System.out.println("--------------------");
        ejercicio2();
    }

    /**
     * Esta funcion estatica, lo que realiza es una demostracion
     * acerca del ejercicio numero 1 de POO.
     */
    public static void ejercicio1(){
        var persona = new Persona();

        persona.setId(1);
        persona.setNombre("Alexander Lopez");
        persona.setDNI("4365764");
        persona.setEdad(21);
        persona.setFechaNacimiento(LocalDate.of(2001, 9, 10));

        persona.mostrar();
        System.out.println("¿La persona es mayor de edad?"+ (persona.esMayorEdad() ? " SI" : "NO"));
    }

    /**
     * Esta funcion estatica, lo que realiza es una demostracion
     * acerca del ejercicio numero 2 de POO.
     */
    public static void ejercicio2(){
        var persona = new Persona(
                2,
                43,
                "Claudia Frutos",
                "21323456",
                LocalDate.of(1978, 4, 13)
        );

        var cuentaPersona = new Cuenta(
                persona,
                2500
        );

        cuentaPersona.mostrar();
        cuentaPersona.ingresar(1000);
        System.out.println("Cantidad actual de dinero en la cuenta: $"+ cuentaPersona.getCantidad());
        cuentaPersona.retirar(4000);
        System.out.println("Cantidad actual de dinero en la cuenta: $"+ cuentaPersona.getCantidad());
    }
}
