import java.util.Scanner;

/*
Crear un programa que funcione como una calculadora de cambio:
Este programa debe recibir como entrada una cantidad de dinero y el costo de un producto.
Utilizando la resta, el programa debe calcular el cambio que se debe entregar al cliente y
mostrar la cantidad de billetes y monedas necesarios para el cambio.
 */
public class Main {
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        double amountMoney,
               costProduct;

        System.out.print("Ingrese la cantidad disponible de dinero: $");
        amountMoney = readInput.nextDouble();
        System.out.print("Ingrese el costo del producto: $");
        costProduct = readInput.nextDouble();

        if(changeCalculator(amountMoney, costProduct) > 0){
            double changeValue = changeCalculator(amountMoney, costProduct);
            System.out.println("¡Excelente! Su vuelto es: $"+ changeValue);
        }else if(changeCalculator(amountMoney, costProduct) == 0){
            System.out.println("¡Excelente! No tiene un vuelto, debido a que pago el costo total del producto.");
        }else{
            System.out.println("Disculpe, no puede comprar el producto... Debido a que no tiene el dinero suficiente.");
        }
    }

    static double changeCalculator(double amountMoney, double costProduct){
        return amountMoney - costProduct;
    }
}
