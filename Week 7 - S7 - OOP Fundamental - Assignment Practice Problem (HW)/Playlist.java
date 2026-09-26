import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String songTitle) {
        if (count < songs.length) {
            songs[count] = songTitle;
            count++;
        }
    }

    public String[] getSongs() {
        // Return a safe copy of only the filled portion of the array
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class PlaylistTest {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        
        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Modifying the copy
        
        System.out.println("p.getSongs()[0] is still: " + p.getSongs()[0]); // Song A
        System.out.println("Song count: " + p.getSongCount()); // 2
    }
}