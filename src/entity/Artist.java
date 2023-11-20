package entity;

public class Artist extends DataObject{
    private final Genre[] genres;

    public Artist(String id, String name, Genre[] genres){
        super(id, name);
        this.genres = genres;
    }

    public Genre[] getGenres(){
        return genres;
    }
}
