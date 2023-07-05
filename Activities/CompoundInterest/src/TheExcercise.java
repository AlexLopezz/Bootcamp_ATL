import java.util.Scanner;

/*
Ejercicio N°3:
Crear un programa para calcular el interés compuesto:
Este programa debe permitir al usuario ingresar el capital inicial,
la tasa de interés y el tiempo en años.
Utilizando la fórmula del interés compuesto.
El programa debe calcular el monto total acumulado y mostrarlo al usuario.
 */
public class TheExcercise {
    public static void main(String[] args) {
        runExcercise();
    }

    /**
     *  Este metodo correra el algoritmo el cual resuelve la
     *  actividad numero 3 del ejercicio del Bootcamp.
     */
    private static void runExcercise() {
        //Variables
        var readInput = new Scanner(System.in);
        double amountMoney, interestRate;
        int countYears;
        boolean follow;

        //Program
        do{
            System.out.print("Capital inicial: $");
            amountMoney = readInput.nextDouble();
            System.out.print("Tasa de interes: %");
            interestRate = readInput.nextDouble();

            System.out.print("Cantidad de años: ");
            countYears = readInput.nextInt();

            double compundInterest = calculateCompundInterest(amountMoney, interestRate, countYears);
            System.out.println("Interes compuesto: $" + compundInterest);

            System.out.println("Digite SI para seguir, de lo contrario cualquier tecla.");
            System.out.println("\tRespuesta: ");
            follow = readInput.next().equalsIgnoreCase("si");
        }while (follow);
    }

    /**
     *  Este metodo calculara el interes compuesto.
     * @param amountMoney cantidad del capital inicial
     * @param interestRate tasa de interes
     * @param countYears cantidad de años.
     * @return el interes compuesto en base a los datos ingresados.
     */
    static double calculateCompundInterest(double amountMoney, double interestRate, double countYears){
        return amountMoney * Math.pow((1 + (interestRate / 100)), countYears);
    }
}
