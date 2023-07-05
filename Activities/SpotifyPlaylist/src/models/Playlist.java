package models;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;
    private Song actualSong;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song getActualSong() {
        return actualSong;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setActualSong(Song actualSong) {
        this.actualSong = actualSong;
    }

    public void addSongToPlayList(Song song){
        songs.add(song);
    }
    public void playPlayList() throws InterruptedException {
        if(songs.size() > 0) {
            int indexSong = 0;
            do {
                actualSong = songs.get(indexSong);
                long durationSong = (long) actualSong.getDuration() * 1000;

                System.out.println("--> Reproduciendo: " + actualSong);
                Thread.sleep(durationSong);
                indexSong++;
            } while (indexSong != songs.size());

            System.out.println("Todas las canciones de su playlist fueron reproducidas.");
        }else {
            System.out.println("Disculpe, debe primero agregar una cancion.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Playlist p){
            return this.name.equals(p.name);
        }else if(obj instanceof String s){
            return this.name.equals(s);
        }else {
            return false;
        }
    }
}
