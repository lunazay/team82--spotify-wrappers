package entity;

import java.util.List;

public class Song extends DataObject{
    private final List<String> artists;
    private final Album album;

    public Song(String id, String name, List<String> artists, Album album){
        super(id, name);
        this.artists = artists;
        this.album = album;
    }

    public List<String> getArtist() {
        return artists;
    }

    public Album getAlbum() {
        return album;
    }

}
