import models.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Ejercicio N°4:
Crear un programa para ingresar las notas de alumnos utilizando programación orientada a objetos:
El programa debe permitir al usuario cargar las notas de varios alumnos.
Cada alumno debe tener atributos como nombre, apellido y una lista de notas.
 */
public class TheExcercise {
    //Static variables
    static Scanner readInput = new Scanner(System.in);
    static List<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        runExcercise();
    }

    /**
     *  Correra el algoritmo encargado de resolver el problema
     *  a la actividad propuesta.
     */
    static void runExcercise(){ showMenu(); }

    /**
     *  Mostrara un menu, el cual tendra una serie de opciones
     *  donde implica cargar notas de alumnos y mostrar el listado
     *  de alumnos cargados.
     */
    private static void showMenu(){
        int option;

        System.out.println("--- CARGAR NOTAS DE ALUMNOS  ---");
        System.out.println("¿Que desea realizar?");
        System.out.println("1. Cargar nota de alumno.");
        System.out.println("2. Listar alumnos cargados previamente.");
        System.out.println("3. Salir.");
        System.out.print("Respuesta: ");

        option = readInput.nextInt();

        switch (option) {
            case 1 -> fillQualificationAlumno();
            case 2 -> showListAlumnos();
            case 3 -> System.exit(0);
        }
        showMenu();
    }

    /**
     *  Este metodo cargara las notas de un alumno
     *  el cual el usuario sera encargado de rellenar
     *  la informacion manualmente.
     */
    static void fillQualificationAlumno() {
        boolean follow;
        do{
            alumnos.add(loadAlumno());
            System.out.println("? Si desea cargar otro ALUMNO, digite SI.. de lo contario cualquier tecla.");
            follow =checkDecisionToKeep().equalsIgnoreCase("si");
        }while (follow);
    }

    /**
     * Este metodo retornara la decision del usuario
     * de seguir en el bucle o no.
     * @return String con la decision del usuario.
     */
    private static String checkDecisionToKeep() {
        System.out.print("Decision: ");
        return readInput.next();
    }

    /**
     *  Este metodo es el encargado de mostrar(si es que hay)
     *  los alumnos cargado por el usuario.
     */
    static void showListAlumnos(){
        System.out.println("--- Listado de alumnos cargados ---");
        if(alumnos.size() > 0){
        alumnos.forEach(System.out::println);
        }else {
            System.out.println("X Disculpe... Por el momento, usted no agrego usuarios.");
        }
    }

    /**
     *  Este metodo cargara toda la data de un Alumno
     *  el cual el usuario se encarga de poner esa informacion.
     * @return un objeto Alumno con los datos ingresados por el usuario.
     */
    static Alumno loadAlumno(){
        List<Double> qualifications = new ArrayList<>();
        boolean keepLoadingQualification;
        int countQualification = 0;

        System.out.println("* Rellene los datos del alumno: ");
        System.out.print("--> Nombre: ");
        String name = readInput.next();
        System.out.print("--> Apellido: ");
        String lastName = readInput.next();
        do{
            countQualification++;
            System.out.print("--> ("+countQualification+")Nota: ");
            var qualification = readInput.nextDouble();
            qualifications.add(qualification);

            System.out.println("? Si desea cargar otra NOTA para este alumno, digite SI.. de lo contario cualquier tecla.");
            keepLoadingQualification = checkDecisionToKeep().equalsIgnoreCase("si");

        }while (keepLoadingQualification);

        return new Alumno(name, lastName, qualifications);
    }
}
