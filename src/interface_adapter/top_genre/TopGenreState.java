package interface_adapter.top_genre;

import entity.Genre;
import use_case.top_genre.TopGenreOutputData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TopGenreState {
    private String id = "";
    private String idError = null;
    private String timeframe = "";
    private String timeframeError = null;
    private String error = null;
    public ArrayList<String> genres = new ArrayList<>();

    public void setGenres(ArrayList<String> genres){
        this.genres = genres;
    }

    public ArrayList<String> getGenres(){
        return this.genres;
    }
    public TopGenreState(){
    }

    public ArrayList<String> prepareSuccessView(TopGenreOutputData genres){
        return genres.getGenreNames();
    }
    public void setId(String id){
        this.id = id;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public String getId(){
        return id;
    }
    public String getTimeframe() {
        return timeframe;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString(){
        return "TopGenreState{" + "id='" + id +
                '\'' + ", timeframe= '"
                + timeframe + '\'' + '}' +
                '\''+ ", genre=" + genres.toString();
    }
}
