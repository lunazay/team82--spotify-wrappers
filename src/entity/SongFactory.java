package entity;
import org.json.JSONObject;
import java.util.List;

public class SongFactory {
    public static Song[] create(JSONObject response) {
        Song[] songs = new Song[50];

        for (int i = 0; i < response.length(); i++) {
            String id = response.getString("id");
            String name = response.getString("name");
            List<String> songList = (List<String>) response.get("songs");
            // TODO: I will completed this soon.
            //  I need to get the length, artist and album so the red on line 15 goes away

            songs[i] = new Song(id, name, length, artist, album);
        }

        return songs;
    }
}
