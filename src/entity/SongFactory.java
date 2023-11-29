package entity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SongFactory {
    /**
     * Creates a list of Song objects from an API response
     * @param response API call for a user's top songs as a JSONObject. The JSONObject has several get methods
     *                 to return desired objects.
     */
    public static Song[] create(JSONObject response) {
        Song[] songs = new Song[50];
        JSONArray items = (JSONArray) response.get("items");

        for (int i = 0; (i < items.length() && i < 50); i++) {
            JSONObject curr_song = (JSONObject) items.get(i);

            String id = (String) curr_song.get("id");
            String name = (String) curr_song.get("name");

            JSONObject albumObject = (JSONObject) curr_song.get("album");
            String albumName = (String) albumObject.get("name");
            Album album = new Album(albumName);

            JSONArray artistsArray = (JSONArray) curr_song.get("artists");
            List<String> artists = new ArrayList<>();

            for (int x = 0; (x < artistsArray.length() && x < 3); x++) {
                JSONObject currArtist = (JSONObject) artistsArray.get(x);
                String currArtistName = currArtist.getString("name");
                artists.add(currArtistName);
            }

            songs[i] = new Song(id, name, artists, album);
        }

        return songs;
    }
}
