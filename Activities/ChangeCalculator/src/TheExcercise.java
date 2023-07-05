import java.util.Scanner;

/*
Ejercicio N°2:
Crear un programa que funcione como una calculadora de cambio:
Este programa debe recibir como entrada una cantidad de dinero y el costo de un producto.
Utilizando la resta, el programa debe calcular el cambio que se debe entregar al cliente y
mostrar la cantidad de billetes y monedas necesarios para el cambio.
 */
public class TheExcercise {
    public static void main(String[] args) {
        runExcercise();
    }

    static void runExcercise(){
        //Variables
        Scanner readInput = new Scanner(System.in);
        double amountMoney,
                costProduct;

        //Cargamos los datos necesarios para verificar:
        System.out.print("Ingrese la cantidad disponible de dinero: $");
        amountMoney = readInput.nextDouble();
        System.out.print("Ingrese el costo del producto: $");
        costProduct = readInput.nextDouble();

        //Verificamos si es correcto darle un vuelto o no.
        checkChangePrice(changeCalculator(amountMoney, costProduct));

    }

    /**
     *  Esta metodo, verificara el valor de cambio.
     * @param changePrice la cantidad devuelta a verificar.
     */
    static void checkChangePrice(double changePrice){
        if(changePrice == 0){
            System.out.println("¡Excelente! No tiene un vuelto, debido a que pago el costo total del producto.");
        }else if(changePrice > 0){
            System.out.println("¡Excelente! Su vuelto es: $"+ changePrice);
        }else{
            System.out.println("Disculpe, no puede comprar el producto... Debido a que no tiene el dinero suficiente.");
        }
    }

    /**
     *  Este metodo calculara el precio de cambio que
     *  resulta de resta el capital disponible por el precio del producto.
     * @param amountMoney capital disponible
     * @param costProduct precio del producto
     * @return el vuelto correspondiente.
     */
    static double changeCalculator(double amountMoney, double costProduct){
        return amountMoney - costProduct;
    }
}
