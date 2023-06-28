import java.util.Scanner;

//Actividad: Hacer una función que calcule el área de un triángulo. Al llamarla debe devolver el área del triángulo.
public class Main {
    public static void main(String[] args) {
        var readInput = new Scanner(System.in);
        double base = 0, height = 0;

        System.out.println("Por favor ingrese la base de su triangulo: ");
        base = readInput.nextDouble();
        System.out.println("Por favor ingrese la altura de su triangulo: ");
        height = readInput.nextDouble();

        System.out.println("El area de su triangulo es: "+ areaTriangle(base, height));
    }

    /**
     *  Este metodo calculara el area de un triangulo que no es mas
     *  que base por altura, luego dividido en dos.
     * @param base de su triangulo
     * @param height de su triangulo
     * @return El area de su triangulo
     */
    private static double areaTriangle(double base, double height){
        return (base * height) / 2;
    }
}
