package api;

import entity.User;
import entity.Artist;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;

public interface DevelopDB {

    void setAuthToken(String authToken);
    User getTopSongs(String time_frame, int numSongs) throws IOException;

    User getTopArtists(String time_frame) throws IOException;

    User createPlaylist()throws IOException;

    String getAuthorizationLink() throws MalformedURLException;

    String getAuthorizationToken(String authCode) throws IOException;


}
