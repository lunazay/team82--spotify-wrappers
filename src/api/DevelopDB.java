package api;

import entity.Song;

import entity.Artist;

import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;


public interface DevelopDB {

    Song[] getTopSongs(String time_frame) throws IOException;

    Artist[] getTopArtists(String time_frame) throws IOException;

    public String getAuthorizationLink() throws MalformedURLException;

    public String getAuthorizationToken(String authCode) throws IOException;

    String get_valence(String songId) throws IOException;

    String getUserId() throws IOException;
    JSONObject getRelatedArtists(String topArtistID) throws IOException;
}
