import java.util.Scanner;
import java.lang.Math;

//Actividad: Hacer una función que calcule el área de un cuadrado. Al llamarla debe devolver el área del cuadrado.
public class Main {
    public static void main(String[] args) {
        double sideSquare = 0;
        var readInput = new Scanner(System.in);

        System.out.print("Ingrese por favor el lado de su cuadrado: ");
        sideSquare = readInput.nextDouble();

        System.out.println("El area de su cuadrado es de: "+ areaSquare(sideSquare));
    }

    /**
     *  Este metodo retornara el area de un cuadrado, que
     *  no es mas que el lado del cuadrado al cuadrado.
     * @param sideSquare Para el calculo del area.
     * @return Area del cuadrado.
     */
    private static double areaSquare(double sideSquare){
        return Math.pow(sideSquare, 2);
    }
}
