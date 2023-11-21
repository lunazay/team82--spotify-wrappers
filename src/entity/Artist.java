package entity;

import java.util.List;
import java.util.ArrayList;
public class Artist extends DataObject{
    private final Genre[] genres;
    private List<String> relatedArtists = new ArrayList<>();

    public Artist(String id, String name, Genre[] genres, List<String> relatedArtists){
        super(id, name);
        this.genres = genres;
        this.relatedArtists = relatedArtists;
    }

    public Genre[] getGenres(){
        return genres;
    }
    public List<String> getRelatedArtists(){
        return relatedArtists;
    }
}
