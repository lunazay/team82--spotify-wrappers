package api;

import entity.Song;
import entity.User;
import entity.Artist;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface DevelopDB {

    public void setAuthToken(String authToken);
    public User getTopSongs(int numSongs);

    public User getTopArtist();

    public String getAuthorizationLink() throws MalformedURLException;

    public String getAuthorizationToken(String authCode) throws IOException;


    String get_valence(Song[] songs);
}
