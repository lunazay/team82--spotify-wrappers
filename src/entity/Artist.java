package entity;
import java.util.List;
import java.util.ArrayList;

public class Artist extends DataObject{
    private final List<String> genres;
    private final List<Song> topTracks;
    private final List<Artist> relatedArtists;

    public Artist(String id, List<String> genres, List<Song> topTracks, List<Artist> relatedArtists){
        super(id);
        this.genres = genres;
        this.topTracks = topTracks;
        this.relatedArtists = relatedArtists;
    }


    public List<String> getGenres(){
        return genres;
    }

    public List<Song> getTopTracks(){
        return topTracks;
    }

    public List<Artist> getRelatedArtists(){
        return relatedArtists;
    }
}
