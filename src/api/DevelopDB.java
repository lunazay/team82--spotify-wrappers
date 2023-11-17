package api;

import entity.User;
import entity.Artist;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface DevelopDB {

    void setAuthToken(String authToken);
    User getTopSongs(int numSongs);

    User getTopArtist();

    String getAuthorizationLink() throws MalformedURLException;

    String getAuthorizationToken(String authCode) throws IOException;


}
