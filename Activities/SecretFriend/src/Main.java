import java.io.Console;
import java.io.IOException;
import java.util.*;

public class Main {
    /*
    Armar un programa para organizar un "amigo invisible", este programa debe permitir a los participantes:
        * ingresar sus nombres.
        * Luego, cada participante debe sentarse frente a la computadora y:
               > escribir su nombre y recibir una indicación sobre a quién debe darle un regalo.
        * El programa también debe limpiar la consola después de que cada participante haya visto su indicación.
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner readInput = new Scanner(System.in);
        String[] participants = new String[0];
        boolean verify;

        System.out.println("---- AMIGO INVISIBLE ----");
        do{
            int lengthParticipants;
            try {
                System.out.print("-> Ingrese la cantidad de participantes que van a jugar(Debe ser un numero par): ");
                lengthParticipants = readInput.nextInt();
                readInput.nextLine();

                if(lengthParticipants % 2 == 0) {
                    participants = new String[lengthParticipants];
                    verify = true;
                }else{
                    System.out.println("X Recuerde que la cantidad de participantes totales deben ser pares, esto para que: ");
                    System.out.println("\t*Cada participante pueda tener su amigo invisible.");
                    verify = false;
                }
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("X Debe ingresar numeros... No letras ni palabras.");
                verify = false;
            }
        }while (!verify);

        //Cargamos el arreglo con los nombres de los participantes:
        for(int i= 0; i < participants.length; i++){
            System.out.print("Ingrese nombre del/la participante("+(i+1)+"): ");
            participants[i] = readInput.nextLine();
        }

        //Obtenemos cada participante con sus respectivos amigos invisibles
        Map<String, String> participantsWithSecretFriend = fillParticipantsWithSecretFriend(participants);

        boolean follow = true;
        verify = false;

        System.out.println("--- Cada participante ya tiene su amigo invisible ---");
        do{
            int selectedOption = 0;

            try {
                System.out.println("¿Que desea realizar?");
                System.out.println("1. Invitar a un participante a que digite su nombre, para ver su amigo invisible.");
                System.out.println("2. Listar todos los participantes con sus respectivos amigos invisibles.");
                System.out.println("3. Terminar juego.");

                selectedOption = readInput.nextInt();
            }catch (NumberFormatException | InputMismatchException n){
                System.out.println("X Debe ingresar numeros... No letras ni palabras.");
            }

            switch (selectedOption){
                case 1:
                    SkipNLines(10);
                    boolean seEncontroParticipante;
                    do{
                        System.out.print("¡Participante!. Ingrese su nombre: ");
                        String nameParticipant = readInput.next();

                        if(participantsWithSecretFriend.containsKey(nameParticipant)){
                            SkipNLines(10);
                            Thread.sleep(1000);
                            System.out.print("Tu amigo invisible es: "+participantsWithSecretFriend.get(nameParticipant));
                            Thread.sleep(5000);
                            SkipNLines(10);
                            seEncontroParticipante = true;
                        }else{
                            System.out.println("No se encontro el participante registrado.\n\t*Recuerde ingresar el nombre que anteriormente ingreso.");
                            seEncontroParticipante = false;
                        }
                    }while (!seEncontroParticipante);
                    break;
                case 2:
                    SkipNLines(10);
                    for(var participant : participantsWithSecretFriend.entrySet()){
                        System.out.println("Participante: "+ participant.getKey() + " - Amigo invisible: "+ participant.getValue());
                        Thread.sleep(1000);
                    }
                    Thread.sleep(5000);
                    SkipNLines(10);
                    break;
                case 3:
                    System.out.println("El juego se terminara! Gracias por jugar, vuelva pronto!");
                    follow = false;
                    verify = true;
                    break;
                default:
                    System.out.println("No eligio ningun opcion.");
            }

        }while (follow && !verify);





    }
    static void SkipNLines(int lines){
        for(int i = 0; i < lines; i++){
            System.out.println();
        }
    }
    static Map<String, String> fillParticipantsWithSecretFriend(String[] participants){
        boolean isSelectedParticipant;
        String[] selectedParticipants = new String[participants.length];
        var random = new Random();

        Map<String, String> secretFriend = new HashMap<>();

        for(int i = 0; i < participants.length; i++){
            do{
                String potentialParticipant = participants[random.nextInt(0, participants.length)];
                if (!participants[i].equals(potentialParticipant) &&
                    !isSelectedParticipant(selectedParticipants, potentialParticipant)) {

                    selectedParticipants[i] = potentialParticipant;
                    secretFriend.put(participants[i], selectedParticipants[i]);
                    isSelectedParticipant = true;

                }else{
                    isSelectedParticipant = false;
                }
            }while (!isSelectedParticipant);
        }
        return secretFriend;
    }
    static boolean isSelectedParticipant(String[] participanteElegidos, String nombreParticipante) {
        return Arrays.stream(participanteElegidos)
                .anyMatch(p -> p != null && p.equals(nombreParticipante));
    }
}

