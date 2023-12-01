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
    private String userID = "31gqehqotfmiji3bbkreneh7d3ia";
    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        String authcode = "AQAADEZoe1mglhTgEIbDdEbW-YyDr_lyvtc3mufELTa3xe41uUvZkELTgkfNWwnWkUpyOHYU-Gu2PTjNSfqEZYgXz039e6AXvUFVNFDMysO7dH8MDKXk_2Z-leJRXx3u83omfOwMu2iIimRHD6sl998c012FvY3NUm5nJqbymfyt77W2lEoKAi-VN9O_gVWpecdYLVPBk-Tj3hvoUBQzbCFKJyn3lPyPUtQddEKxZHb7GiFf0iuBf5Ed60MmrztU-VeVX3ZVCixdgnD9SArf8iC7rf1XGa95fX7RZUiCnPiWQxPFi5EpSNK9KzsNh7hfHbI";
        System.out.println(api.getAuthorizationToken(authcode));
    }

    /**
     * Retrieves the top genres for a user.
     *
     * @return ArrayList of top genres.
     * @throws Exception If an error occurs during data retrieval.
     */
    public ArrayList<Genre> getTopGenres() throws Exception{
        UserDataAccessObject user = new UserDataAccessObject();
        ArrayList<Genre> topGenres = user.getTopGenres(userID, "long_term");
        return topGenres;
    }

    @org.junit.Test
    public void testTopGenre() throws Exception{
        ArrayList<Genre> topGenres = getTopGenres();
        assert(Objects.equals(topGenres.get(0).getName(), "Pop"));
    }
}
