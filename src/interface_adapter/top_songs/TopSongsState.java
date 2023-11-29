package interface_adapter.top_songs;

import java.util.ArrayList;

public class TopSongsState {
    private String id = "";
    private String idError = null;
    private String timeframe = "";
    private String timeframeError = null;

    public String error;
    public ArrayList<String> songs;

    public TopSongsState(TopSongsState copy){
        id = copy.id;
        idError = copy.idError;
        timeframe = copy.timeframe;
        error = copy.error;
        songs = copy.songs;
    }
    public TopSongsState(){
    }

    public void setSongs(ArrayList<String> songs){
        this.songs = songs;
    }

    public ArrayList<String> getSongs(){
        return this.songs;
    }
    public void setId(String id){
        this.id = id;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }
    // a little worried about the testing code coverage here because i don't really see any usages here of the error
    public void setIdError(String idError) {
        this.idError = idError;
    }
    public String getId(){
        return id;
    }
    public String getTimeframe() {
        return timeframe;
    }

    public String getIdError() {
        return idError;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString(){
        return "TopGenreState{" + "id='" + id +
                '\'' + ", timeframe= '"
                + timeframe + '\'' + '}';
    }
}


