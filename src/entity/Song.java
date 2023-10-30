package entity;

public class Song extends DataObject{
    private final int length;
    private final Artist artist;
    private final String album;

    public Song(int length, Artist artist, String album){
        this.length = length;
        this.artist = artist;
        this.album = album;
    }

    @Override
    public Artist getArtist() {
        return artist;
    }
    @Override
    public String getAlbum() {
        return album;
    }
    @Override
    public int getLength() {
        return length;
    }
}
