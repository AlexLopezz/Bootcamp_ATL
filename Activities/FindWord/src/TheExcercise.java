import models.MisteryWord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*
Ejercicio N°5:
Crear un juego de adivinar la palabra: Este juego consiste en mostrar una pista o descripción y
permitir al jugador adivinar la palabra correcta.
Por ejemplo, el programa podría mostrar el mensaje: "Es un animal muy grande, con trompa. ¿Qué es?"
El jugador debe ingresar su respuesta y el programa debe verificar si es correcta o no.
 */
public class TheExcercise {
    //Global Variables
    static Scanner readInput = new Scanner(System.in);
    static List<MisteryWord> misteryWords = new ArrayList<>();

    public static void main(String[] args) {
        runExcercise();
    }

    /**
     *  Este metodo correra el algoritmo necesario para resolver
     *  el problema de la actividad propuesta.
     */
    static void runExcercise(){ showMenu(); }

    /**
     *  Este metodo mostrara un menu con las opciones disponibles
     *  para manipular el algoritmo resuelto de la actividad.
     */
    static void showMenu(){
        System.out.println("--- PALABRA MISTERIOSA ---");
        System.out.println("¿QUE DESEA HACER?");
        System.out.println("1. Agregar una palabra misteriosa.");
        System.out.println("2. Adivinar una palabra misteriosa.");
        System.out.println("3. Salir.");
        System.out.print("\tDecision: ");

        var option = readInput.nextInt();
        readInput.nextLine(); //Esto para almacenar el salto de linea que hace nextInt().

        switch (option) {
            case 1 -> addNewMysteryWord();
            case 2 -> guessWord();
            case 3 -> System.exit(0);
            default -> System.out.println("X --> Disculpe, debe eligir una opcion correcta.");
        }
        showMenu(); //Recursivo hasta que aprete la opcion 3.
    }

    /**
     * Este metodo agregara a la lista global una nueva palabra
     * misteriosa, con la posibilidad de adivinar con o sin
     * opciones la palabra.
     */
    static void addNewMysteryWord(){
        List<String> optionsForMisteryWord = new ArrayList<>();

        System.out.print("--> Ingrese nombre de la palabra misteriosa: ");
        String name = readInput.nextLine();
        System.out.print("--> Ingrese una descripcion para adivinar la palabra: ");
        String description = readInput.nextLine();

        System.out.print("¿Desea agregar una serie de opciones para adivinar la palabra correcta?");
        var decision = checkDesicionUser();

        if(decision.equalsIgnoreCase("si")){
            int countOptions = 0;
            boolean keepAddingOptions;
            do{
                countOptions++;
                System.out.print("-->("+countOptions+") Ingrese una OPCION para la palabra correcta:  ");
                String option = readInput.nextLine();

                if(!option.equalsIgnoreCase(name)) {
                    optionsForMisteryWord.add(option);
                }else{
                    System.out.println("X --> NO agregues como opcion la palabra misteriosa... Eso lo hacemos por vos ;)");
                }

                System.out.println("? --> ¿Desea agregar otra opcion para esta palabra?");
                keepAddingOptions = checkDesicionUser().equalsIgnoreCase("si");

            }while (keepAddingOptions);

        }

        MisteryWord misteryWord = new MisteryWord(
                name,
                description
        );

        if(optionsForMisteryWord.size() > 0){
            misteryWord.setOptions(optionsForMisteryWord);
        }

        misteryWords.add(misteryWord);
    }

    /**
     *  Este metodo mostrara la pista de una palabra misteriosa cualquiera
     *  de la lista y el usuario debera ingresar la palabra o la opcion
     *  correcta, luego se informara si acerto o no.
     */
    static void guessWord(){
        var random = new Random();
        if(misteryWords.size() > 0) {
            MisteryWord misteryWord = misteryWords.get(random.nextInt(0, misteryWords.size()));

            System.out.println("--- ADIVINAR PALABRA MISTERIOSA ---");

            System.out.println("Pista: "+misteryWord.getDescription());
            if(misteryWord.getOptions().size() > 1){
                int countOptions = 0;
                System.out.println("* Opciones: ");
                for(var m : misteryWord.getOptions()){
                    System.out.println((countOptions)+". "+ m);
                    countOptions++;
                }
                System.out.print("*--> Escriba la opcion que usted cree que es(en numero): ");
                int optionUser = readInput.nextInt();

                if(optionUser >= 0 && optionUser <= countOptions){
                    if(misteryWord.checkIsCorrectOption(optionUser)){
                        System.out.println("¡Felicitaciones! Adivinaste la palabra misteriosa :D");
                    }else{
                        System.out.println("Desgraciadamente, la opcion que eligio no es la palabra misteriosa! :(");
                    }
                }
            }else{
                System.out.print("*--> Escriba la palabra que usted cree que es: ");
                String word = readInput.nextLine();

                if(misteryWord.checkIsCorrectOption(word)){
                    System.out.println("¡Felicitaciones! Adivinaste la palabra misteriosa :D");
                }else{
                    System.out.println("Desgraciadamente, la opcion que eligio no es la palabra misteriosa! :(");
                }

            }

        }else{
            System.out.println("X --> Disculpe, no hay cargadas palabras misteriosas.");
        }
    }

    /**
     * Este metodo sirve como utilidad para cuando deseemos preguntar
     * al usuario si quiere seguir o no realizando una iteracion.
     * @return String con la decision del usuario.
     */
    static String checkDesicionUser(){
        System.out.println("\t*Escriba 'SI' para hacerlo, de lo contrario cualquier tecla.");
        System.out.print("Decision: ");
        return readInput.nextLine();
    }
}
