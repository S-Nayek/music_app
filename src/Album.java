import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title){
        for(Song s:songs){
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }
    public void addSongsToAlbum(String title, double duration){
        Song s= new Song(title,duration);
        if(findSong(s.getTitle())){
            System.out.println("this song id already present in the album");
        }
        else{
            songs.add(s);
            System.out.println("new song has been added");
        }
    }
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playlist){

        if(findSong(title)){
            for(Song song:songs){
                if(song.getTitle().equals(title)){
                    playlist.add(song);
                    System.out.println("song is added to the playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("song is not available in the album");
        }
    }
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playlist){
        int index =trackNo-1;
        if(index>=0 && index<songs.size()){
            playlist.add(songs.get(index));
        }
        else{
            System.out.println("invalid track no");
        }
    }
}
