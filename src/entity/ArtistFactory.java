package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArtistFactory {
    /**
     * Creates a list of Artist objects from an API response
     * @param response API call for a user's top artists
     */
    public static Artist[] create(String response) {
        String[] artistData = response.split();         // TODO: figure out what separates each artist
        Artist[] artists = new Artist[50];

        for (int i = 0; i < artistData.length; i++) {
            artistData[i]                               // TODO: manipulate data to get these fields
            String id = "";
            String name = "";
            Genre[] genres = new Genre[5];

            for (int x = 0; x < 5; x++) {
                genres[x] = artistData[i][];            // TODO: figure out where genre is
            }

            artists[i] = new Artist(id, name, genres);
        }

        return null;
    }
}
