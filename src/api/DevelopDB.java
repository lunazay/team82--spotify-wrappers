package api;

import entity.User;
import entity.Artist;
import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public interface DevelopDB {

    void setAuthToken(String authToken);
    User getTopSongs(String time_frame, int numSongs) throws IOException;

    Artist[] getTopArtists(String time_frame) throws IOException;

    Artist[] getRelatedArtists(String topArtistID)throws IOException;

    public String getAuthorizationLink() throws MalformedURLException;

    public String getAuthorizationToken(String authCode) throws IOException;


    String get_valence(String songId) throws IOException;
}
