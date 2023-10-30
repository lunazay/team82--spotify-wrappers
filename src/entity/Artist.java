package entity;
import java.util.List;
import java.util.ArrayList;

public class Artist extends DataObject{
    private final List<String> genres;
    private final List<Song> topTracks;
    private final List<Artist> relatedArtists;

    public Artist(List<String> genres, List<Song> topTracks, List<Artist> relatedArtists){
        super(id);
        this.genres = genres;
        this.topTracks = topTracks;
        this.relatedArtists = relatedArtists;
    }

    @Override
    public List<String> getGenres(){
        return genres;
    }
    @Override
    public List<Song> getTopTracks(){
        return topTracks;
    }
    @Override
    public List<Artist> getRelatedArtists(){
        return relatedArtists;
    }
}
