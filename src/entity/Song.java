package entity;

public class Song extends DataObject{
    private final int length;
    private final Artist artist;
    private final String album;

    public Song(String id, int length, Artist artist, String album){
        super(id);
        this.length = length;
        this.artist = artist;
        this.album = album;
    }


    public Artist getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getLength() {
        return length;
    }
}
