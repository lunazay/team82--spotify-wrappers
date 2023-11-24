package entity;

import org.json.JSONObject;
import java.util.List;

public class ArtistFactory {
    /**
     * Creates a list of Artist objects from an API response
     * @param response API call for a user's top artists as a JSONObject. The JSONObject has several get methods
     *                 to return desired objects.
     */
    public static Artist[] create(JSONObject response) {
        Artist[] artists = new Artist[50];

        for (int i = 0; i < response.length(); i++) {
            String id = response.getString("id");
            String name = response.getString("name");
            List<String> genreList = (List<String>) response.get("genres");
            Genre[] genres = new Genre[5];
            List<String> relatedArtists = (List<String>) response.get("related artists");

            for (int x = 0; x < 5; x++) {
                genres[x] = new Genre(genreList.get(x));
            }

            artists[i] = new Artist(id, name, genres, relatedArtists);
        }

        return artists;
    }
}
