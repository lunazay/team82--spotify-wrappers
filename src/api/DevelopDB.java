package api;

import entity.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public interface DevelopDB {

    public void setAuthToken(String authToken);
    public User getTopSongs(int numSongs);

    public User getTopArtist();

    public String getAuthorizationLink() throws MalformedURLException;

    public String getAuthorizationToken(String authCode) throws IOException;


    String get_valence(ArrayList<String> songIds);
}
