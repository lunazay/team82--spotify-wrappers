package entity;

import java.util.ArrayList;
import java.util.List;

public class Song extends DataObject{
    private final int length;
    private List<String> artists = new ArrayList<>();

    private final String album;

    public Song(String id, String name, int length, List<String> artists, String album){
        super(id, name);
        this.length = length;
        this.artists = artists;
        this.album = album;
    }


    public List<String> getArtist() {
        return artists;
    }

    public String getAlbum() {
        return album;
    }

    public int getLength() {
        return length;
    }
}
