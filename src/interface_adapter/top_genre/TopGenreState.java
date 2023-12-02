package interface_adapter.top_genre;

import java.util.ArrayList;

public class TopGenreState {
    public ArrayList<String> genres = new ArrayList<>();
    public String genresError = null;

    public TopGenreState(){
    }

    public void setGenres(ArrayList<String> genres){
        this.genres = genres;
    }
    public ArrayList<String> getGenres(){
        return this.genres;
    }

    public void setGenresError(String error) {
        this.genresError = error;
    }

    public String getGenresError() {
        return genresError;
    }

    @Override
    public String toString(){
        return "TopGenreState{genres=" + genres.toString() + "}";
    }
}
