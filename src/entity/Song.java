package entity;

import java.util.ArrayList;
import java.util.List;

public class Song extends DataObject{
    private final int length;
    private List<String> artists = new ArrayList<>();

    private final Album[] albums;

    public Song(String id, String name, int length, List<String> artists, Album[] albums){
        super(id, name);
        this.length = length;
        this.artists = artists;
        this.albums = albums;
    }


    public List<String> getArtist() {
        return artists;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public int getLength() {
        return length;
    }
}
