package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArtistFactory {
    /**
     * Creates a list of Artist objects from an API response
     * @param response API call for a user's top artists
     */
    public static Artist[] create(List<HashMap<String, Object>> response) {
        Artist[] artists = new Artist[50];

        for (int i = 0; i < response.size(); i++) {
            String id = response.get(i).get("id").toString();
            String name = response.get(i).get("name").toString();
            List<String> genre_list = (List<String>) response.get(i).get("genres");
            Genre[] genres = new Genre[5];

            for (int x = 0; x < 5; x++) {
                genres[x] = new Genre(genre_list.get(x));
            }

            artists[i] = new Artist(id, name, genres);
        }

        return null;
    }
}
