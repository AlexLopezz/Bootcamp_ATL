import models.Circle;
import models.Figure;
import models.Rectangle;
import models.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/*
    Ejercicio GRUPAL N°1:
    Crea una clase base llamada "Figura" con métodos para calcular el área y el perímetro de una figura geométrica
    genérica.
    Luego, crea clases derivadas como "Triangulo", "Rectangulo" y "Circulo", que hereden de la clase base
    y sobreescriban los métodos para calcular el área y el perímetro según su forma específica.
    Crea instancias de las diferentes figuras y muestra sus áreas y perímetros.
 */
public class TheExcercise {
    //GLOBAL VARIABLES

    static Scanner readInput = new Scanner(System.in); //Para leer datos del usuario.
    static List<Figure> geometricFigures = new ArrayList<>(); //Para guardar las figuras que crea el usuario.

    public static void main(String[] args) {
        runExcercise();
    }

    /**
     *  Este metodo es el encargado de ejecutar el algoritmo
     *  que resuelve la actividad planteada.
     */
    static void runExcercise(){
        showMenu();
    }

    /**
     *  Este metodo mostrara un menu de opciones para crear nuevas
     *  figuras geometricas, sumar todas las areas de las figuras o
     *  terminar el programa.
     */
    static void showMenu(){
        System.out.println("--- FIGURAS GEOMETRICAS ---");
        System.out.println("1. Creacion de figuras");
        System.out.println("2. Sumar todas las areas de figuras creadas");
        System.out.println("3. Salir");
        int option = Integer.parseInt(decisionUser());

        switch (option){
            case 1 -> createFigure();
            case 2 -> sumAllFigureArea();
            case 3 -> System.exit(0);
            default -> System.out.println("X Debe eleigir una opcion disponible.");
        }

        showMenu();
    }

    /**
     *  Este metodo creara una figura geometrica
     *  dependiendo de la decision del usuario.
     *
     */
    static void createFigure(){
        System.out.println("¿QUE FIGURA DESEA CREAR?");
        System.out.println("1. Triangulo");
        System.out.println("2. Rectangulo");
        System.out.println("3. Circulo");

        int option = Integer.parseInt(decisionUser());

        switch (option) {
            case 1 -> {
                Triangle t = new Triangle();
                t.fillData();
                t.showAreaAndPerimeter();
                geometricFigures.add(t);
            }
            case 2 -> {
                Rectangle r = new Rectangle();
                r.fillData();
                r.showAreaAndPerimeter();
                geometricFigures.add(r);
            }
            case 3 -> {
                Circle c = new Circle();
                c.fillData();
                c.showAreaAndPerimeter();
                geometricFigures.add(c);
            }
            default -> System.out.println("X No eligio ninguna de las opciones disponibles.");
        }
    }

    /**
     *  Este metodo sumara todas las areas de las figuras
     *  geometricas creadas por el usuario y lo notificara
     *  por consola.
     */
    static void sumAllFigureArea(){
        double resultSumAllFigureArea = geometricFigures
                .stream()
                .flatMapToDouble(figure -> DoubleStream.of(figure.getArea()))
                .sum();

        System.out.printf("--> La suma de todas las areas de las figuras creadas actualmente es de: %.2f\n", resultSumAllFigureArea);
    }

    //UTILS

    /**
     *  Este metodo sirve para leer por consola lo que indica
     *  el usuario.
     * @return String con lo que escribio el usuario
     */
    static String decisionUser(){
        System.out.print("--> Respuesta: ");
        return readInput.next();
    }
}
