package entity;
import org.json.JSONArray;
import org.json.JSONObject;
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
            int length = (int) curr_song.get("length");
            Album album = new Album((String) curr_song.get("album"));

            List<String> artist = (List<String>) curr_song.get("artist");

            songs[i] = new Song(id, name, length, artist, album);
        }

        return songs;
    }
}
