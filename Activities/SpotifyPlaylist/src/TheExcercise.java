import models.Playlist;
import models.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/*
Ejercicion N°6:
Armar un programa que funcione como una lista de reproducción de Spotify simple:
El programa debe permitir al usuario agregar canciones a una lista de reproducción.
Cada canción debe tener atributos como título, artista y duración.
El programa debe permitir reproducir las canciones en orden y mostrar la información
de la canción que se está reproduciendo en ese momento.
 */
public class TheExcercise {
    //Global variables
    static Scanner readInput = new Scanner(System.in);
    static List<Playlist> playlistsCreated = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        runExcercise();
    }

    /**
     *  Este metodo es el encargado de resolver el algoritmo propuesto
     *  de la actividad.
     * @throws InterruptedException Excepcion por si al pausar el hilo ocurre algun error.
     */
    static void runExcercise() throws InterruptedException {
        showMenu();
    }

    /**
     *  Este metodo, muestra un menu el cual muestra al usuario
     *  diferentes opciones el cual el puede elegir.
     * @throws InterruptedException Excepcion por si al pausar el hilo ocurre algun error.
     */
    static void showMenu() throws InterruptedException {
        System.out.println("--- PLAYLIST: SPOTIFY ---");
        System.out.println("¿QUE DESEA REALIZAR?");
        System.out.println("1. Crear nueva playlist.");
        System.out.println("2. Reproducir playlist.");
        System.out.println("3. Agregar cancion a playlist");
        System.out.println("4. Salir");
        System.out.print("\tDecision: ");
        var option = readInput.nextInt();
        readInput.nextLine();

        switch (option) {
            case 1 -> createPlayList();
            case 2 -> playPlayList();
            case 3 -> addSongToPlayList();
            case 4 -> System.exit(0);
            default -> System.out.println("X --> No se eligio ninguna opcion disponible...");
        }
        showMenu();
    }

    /**
     *  Este metodo es el encargado de crear una nueva
     *  playlist.
     */
    static void createPlayList(){
        System.out.println("--- CREACION DE PLAYLIST ---");
        System.out.print("*--> Nombre: ");
        String namePlaylist = readInput.nextLine();

        playlistsCreated.add(new Playlist(namePlaylist));
        System.out.println("¡Playlist creada correctamente!");
    }

    /**
     *  Este metodo generara un objeto nuevo con los datos
     *  que ingresa el usuario.
     * @return una nueva Cancion
     */
    static Song generateSong(){
        System.out.print("--> Ingrese nombre de la cancion: ");
        String name = readInput.nextLine();
        System.out.print("--> Ingrese artista de la cancion: ");
        String artist = readInput.nextLine();
        System.out.print("--> Ingrese duracion de la cancion: ");
        double duration = readInput.nextDouble();

        return new Song(
                name,
                artist,
                duration
        );
    }

    /**
     *  Este metodo 'simulara' una reproduccion de todas las canciones
     *  cargadas de la playlist del usuario.
     * @throws InterruptedException Excepcion por si al pausar el hilo ocurre algun error.
     */
    static void playPlayList() throws InterruptedException {
        System.out.println("--- REPRODUCIR PLAYLIST ---");

        Optional<Playlist> optPlaylist = findPlayList();
        if(optPlaylist.isPresent()){
            optPlaylist.get().playPlayList();
        }else {
            System.out.println("X --> No se encontro la playlist que usted busca.");
        }
    }

    /**
     *  Este metodo agregara una nueva cancion a la playlist que
     *  elija el usuario. Para ello debe existir almenos una playlist.
     */
    static void addSongToPlayList(){
        System.out.println("--- AGREGAR CANCION A PLAYLIST ---");

        Optional<Playlist> optPlaylist = findPlayList();
        if(optPlaylist.isPresent()){
            optPlaylist.get().addSongToPlayList(generateSong());

            System.out.println("¡Cancion agregada correctamente!");
        }else {
            System.out.println("X --> No se encontro la playlist que usted busca.");
        }
    }

    //UTILS: Metodos utiles

    /**
     *  Este metodo verificara si en toda la lista de playlist
     *  del usuario existe la que el busca.
     * @param name de la playlist que esta buscando el usuario.
     * @return true: si lo encuentro, false: si no lo encuentra.
     */
    static boolean existPlayList(String name){
        return playlistsCreated.stream().anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

    /**
     *  Este metodo obtendra la playlist que el usuario
     *  esta buscando.
     * @param name de la playlist.
     * @return una referencia del objeto que se encuentra en la lista de Playlist.
     */
    static Playlist getPlayList(String name){
        return playlistsCreated.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    /**
     *  Este metodo retornara el nombre de la playlist que esta
     *  buscando el usuario.
     * @return String del nombre de Playlist que busca el usuario.
     */
    static String namePlayList(){
        System.out.print("*--> Nombre de su playlist: ");
        return readInput.nextLine();
    }

    /**
     *  Este metodo retornara(o no) si encontro la playlist especificada
     *  en un Optional.
     * @return Optional con la playlist que busca el usuario.
     */
    static Optional<Playlist> findPlayList(){
        String namePlayList = namePlayList();
        if(existPlayList(namePlayList)){
            return Optional.of(getPlayList(namePlayList));
        }else {
            return Optional.empty();
        }
    }

}

