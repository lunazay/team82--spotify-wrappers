package interface_adapter.top_songs;

import java.util.ArrayList;

public class TopSongsState {
    public ArrayList<String> songs;
    public String songsError;

    public TopSongsState() {}

    public void setSongs(ArrayList<String> songs){
        this.songs = songs;
    }
    public ArrayList<String> getSongs(){
        return this.songs;
    }

    public void setSongsError(String error) {
        this.songsError = error;
    }
    public String getSongsError() {
        return this.songsError;
    }

    @Override
    public String toString(){
        return "TopSongsState{ songs=" + songs.toString() + '}';
    }
}


