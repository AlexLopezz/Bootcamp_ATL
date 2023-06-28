import java.util.*;
public class Main {
    public static void main(String[] args) {
        String password = generatePass();
        System.out.println("Contraseña generada: "+ password);
    }

    /**
     *  Este metodo generara una contraseña random
     *  que empezara con las iniciales 'passALF' y una serie de numeros.
     * @return Contraseña random.
     */
    private static String generatePass(){
        var random = new Random();
        int aleatoryNumber = random.nextInt(10000);

        return "passALF"+aleatoryNumber;
    }
}
