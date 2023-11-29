package entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collections;

public class ArtistFactory {
    /**
     * Creates a list of Artist objects from an API response
     * @param response response from the API call for a user's top artists as a JSONObject. The JSONObject has
     *                 a JSONArray "items" with individual objects representing each object.
     * @return array of Artist objects of the user's <=50 top artists.
     */
    public static Artist[] create(JSONObject response) {
        Artist[] artists = new Artist[50];
        JSONArray items = (JSONArray) response.get("items");

        for (int i = 0; (i < items.length() && i < 50); i++) {
            JSONObject currArtist = (JSONObject) items.get(i);
            String id = (String) currArtist.get("id");
            String name = (String) currArtist.get("name");
            JSONArray genreArray = (JSONArray) currArtist.get("genres");
//            JSONArray relatedArtistsArray = (JSONArray) currArtist.get("related artists");

            Genre[] genres = new Genre[10];
            for (int x = 0; (x < genreArray.length() && x < 5); x++) {
                genres[x] = new Genre((String) genreArray.get(x));
            }

//            List<String> relatedArtists = new ArrayList<>(5);
//            for (int y = 0; (y < relatedArtistsArray.length() && y < 5); y++) {
//                relatedArtists.set(y, (String) relatedArtistsArray.get(y));
//            }

            // artists[i] = new Artist(id, name, genres, relatedArtists);
            artists[i] = new Artist(id, name, genres, Collections.emptyList());
        }

        return artists;
    }
}
