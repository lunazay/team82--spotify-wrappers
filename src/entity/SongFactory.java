package entity;
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

        for (int i = 0; i < response.length(); i++) {
            String id = response.getString("id");
            String name = response.getString("name");

            int length = response.getInt("length");

            List<String> artist = (List<String>) response.get("artist");
            List<String> albumList = (List<String>) response.get("album");

            Album[] album = new Album[50]; // I put 50 since each song has an album
            //String album = response.getString("album");

            for (int x = 0; x < 50; x++) {
                album[x] = new Album(albumList.get(x));
            }


            songs[i] = new Song(id, name, length, artist, album);
        }

        return songs;
    }
}
