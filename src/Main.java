import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Album album1 =new Album("moosa","sidhu musawala");
        album1.addSongsToAlbum("234",5.23);
        album1.addSongsToAlbum("rider",6.25);
        album1.addSongsToAlbum("lastRide",3.02);

        Album album2 =new Album("sad","Arijit singh");
        album2.addSongsToAlbum("gerua",6.00);
        album2.addSongsToAlbum("jeena",8.99);

        LinkedList<Song> myplaylist =new LinkedList<>();
        album1.addToPlaylistFromAlbum("234",myplaylist);
        album1.addToPlaylistFromAlbum("rider",myplaylist);
        album2.addToPlaylistFromAlbum("gerua",myplaylist);
        album2.addToPlaylistFromAlbum("jeena",myplaylist);

        play(myplaylist);
    }
    public static void play(LinkedList<Song> playlist){
        Scanner sc =new Scanner(System.in);
        ListIterator<Song> itr =playlist.listIterator();

        boolean  isForward = false;

        if(playlist.size()>0){
            System.out.println("currently playing : ");
            System.out.println(itr.next());
            isForward=true;
        }
        else{
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("enter your choice:");
        printMenu();

        boolean quit =false;
        while (!quit){
            int choice =sc.nextInt();
            switch (choice){
                case 1:
                    if(!isForward){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("you reached the end of the playList");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("you are at the start of the playlist");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward=false;
                        }

                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=true;

                        }

                        }

                    break;
                case 4:
                    break;
                case 5:
                    printMenu();
                case 6:
                    printSongs(playlist);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }
    public static void printSongs(LinkedList<Song> playlist){
        for(Song song:playlist)
            System.out.println(song);
        return;
    }
    public static void printMenu(){

        System.out.println("1 - play the next song");
        System.out.println("2 - play the previous song");
        System.out.println("3 - repeat the current song");
        System.out.println("4 - delete the current song from playlist");
        System.out.println("5 - show menu again");
        System.out.println("6 - print all song from playlist");
        System.out.println("7 - exit");
    }
}