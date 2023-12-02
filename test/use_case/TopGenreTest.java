package use_case;

import java.io.IOException;
import java.util.Objects;
import java.util.ArrayList;

import api.SpotDevelopDB;
import data_access.UserDataAccessObject;
import entity.Genre;

/**
 * This class contains tests for the TopGenres use case.
 */
public class TopGenreTest {
    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationToken("AQA_Hqap0MiTcGUfM-HEX7QcnBeVzD-G19rw9oX1dwIp7Et3b820SYQrLgC87dzEpjE4q30dSiUwwWgSSYVv5pNopyFSX5EBS2i0o7MM9b-yCMuE6gJnANE9HRy6wM8nv-hBoat1_2fDfln5PcLk9mG23ZBeZuZKeGCQZ2aY9rqRBf4sZAEP3eeE8CM6IQ00-7R7_s3OHVUuX0sHSZ_AZpwPMDnPKDXloXb9m0pmXgPYdRTCcteb7GeoImNYAZ4qy0vaZuUB3kPBxT0SwE4lp937OwWMqUWtYV8WPgzrA5ixYfqM0oOrYRqEsV7T0-xcU7M"));
    }

    /**
     * Retrieves the top genres for a user.
     *
     * @return ArrayList of top genres.
     * @throws Exception If an error occurs during data retrieval.
     */
    public ArrayList<Genre> getTopGenres() throws Exception{
        UserDataAccessObject user = new UserDataAccessObject();
        ArrayList<Genre> topGenres = user.getTopGenres("luna987654321", "short_term");
        return topGenres;
    }

    @org.junit.Test
    public void testTopGenre() throws Exception{
        ArrayList<Genre> topGenres = getTopGenres();
        assert(Objects.equals(topGenres.get(0).getName(), "canadian hip hop"));
    }
    @org.junit.Test
    public void testTopFiveGenres() throws Exception {
        ArrayList<Genre> topGenres = getTopGenres();
        assert(topGenres.size() == 5);
    }
}
