package data_access;

import api.DevelopDB;
import api.SpotDevelopDB;
import entity.Artist;
import entity.Song;
import entity.Album;
import entity.Genre;
import entity.User;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.get_valence.GetValenceDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.related_artists.RelatedArtistsDataAccessInterface;
import use_case.top_album.TopAlbumDataAccessInterface;
import use_case.top_artists.TopArtistsDataAccessInterface;
import use_case.top_genre.TopGenreDataAccessInterface;
import use_case.top_songs.TopSongsDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserDataAccessObject implements TopSongsDataAccessInterface, TopGenreDataAccessInterface,
        GetValenceDataAccessInterface, RelatedArtistsDataAccessInterface, TopArtistsDataAccessInterface, TopAlbumDataAccessInterface,
        LoginUserDataAccessInterface {

    private final DevelopDB api = new SpotDevelopDB();

    /**
     * Makes an API call to get a user's top songs over a desired timeframe.
     * @param id        the user's Spotify id
     * @param timeframe the API call time_range (short_term: 4 weeks, medium_term: 6 months, long_term: all time)
     * @return          an ArrayList of the user's top songs, as Song objects
     */
    @Override
    public Song[] getTopSongs(String id, String timeframe) throws Exception {
        Song[] songs = api.getTopSongs(timeframe);

        if (songs.length > 0) {
            return songs;
        }

        throw new Exception();
    }

    /**
     * Makes an API call to get a user's top five genres over a desired timeframe.
     * @param id        the user's Spotify id
     * @param timeframe the API call time_range (short_term: 4 weeks, medium_term: 6 months, long_term: all time)
     * @return          an ArrayList of the user's top five genres, as Genre objects
     */
    @Override
    public ArrayList<Genre> getTopGenres(String id, String timeframe) throws Exception {
        Artist[] topArtist = getTopArtists(id, timeframe);
        ArrayList<Genre> topGenres = new ArrayList<Genre>();
        int count = 0;
        for (Artist artist: topArtist){
            // I want to return an array list of Genre objects because that is how we
            // decided our design implementation will be
            Genre[] genres = artist.getGenres();
            Genre topGenre = genres[0];

            if (!topGenres.contains(topGenre) && topGenre != null) {
                topGenres.add(topGenre);
                count++;
                if (count >= 5) {
                    break;
                }
            }

            // since I only want the top 5 genres, I'm only counting till 5
            if (count >= 5) {
                break;
            }
        }
        return topGenres;
    }

    /**
     * Makes an API call to get a user's top albums over a desired timeframe.
     * @param id        the user's Spotify id
     * @param timeframe the API call time_range (short_term: 4 weeks, medium_term: 6 months, long_term: all time)
     * @return          an ArrayList of the user's top albums, as Album objects
     */
    @Override
    public ArrayList<Album> getTopAlbums(String id, String timeframe) throws Exception {

        Song[] topSongs = api.getTopSongs(timeframe);
        ArrayList<Album> topAlbums = new ArrayList<>();

        for (Song song : topSongs) {
            // my thought process here is to iterate through the Songs and for each song,
            // get its album and return in a list.
            Album album = song.getAlbum();
            topAlbums.add(album);
        }

        return topAlbums;
    }


    /**
     * Makes an API call to get a user's top artists over a desired timeframe.
     * @param id        the user's Spotify id
     * @param timeframe the API call time_range (short_term: 4 weeks, medium_term: 6 months, long_term: all time)
     * @return          an ArrayList of the user's top artists, as Artist objects
     */
    @Override
    public Artist[] getTopArtists(String id, String timeframe) throws Exception {
        Artist[] artists = api.getTopArtists(timeframe);

        if (artists.length > 0) {
            return artists;
        }

        throw new Exception();
    }

    /**
     * Gets the average valence of the user's top songs.
     * @param id contains the user id to specify the api call to top songs
     * @param timeframe contains the timeframe to specify the api call to top songs
     * @return the average valence of the user's top songs.
     */
    @Override
    public String getValence(String id, String timeframe) throws Exception {

        try {
            Song[] songs = getTopSongs(id, timeframe); // getting top songs. Throws exception if
                                                       // there are 0 top songs.

            double valence_sum = 0;
            int num_elements = 0;

            for (Song song : songs) {
                double valence = Double.parseDouble(api.get_valence(song.getId()));
                valence_sum += valence;
                num_elements++;
            }
            // if user has listened to at least one song, return the mean valence
            return String.valueOf(valence_sum / num_elements);

        } catch (Exception e) {
            throw new Exception("Listen to some music bro!");
            // throws this exception if the user has listened to no music.
        }


    }

    /**
     * Makes an API call to get a user's top artists over a desired timeframe, then uses the first artist and
     * returns the related artists of them.
     * @param id        the user's Spotify id
     * @param timeframe the API call time_range (short_term: 4 weeks, medium_term: 6 months, long_term: all time)
     * @return          a List of the top artist's related artists, as a list of strings
     */
    @Override
    public List<String> getRelatedArtists(String id, String timeframe) throws Exception {
        Artist topArtist = getTopArtists(id, timeframe)[0];
        String topArtistId = topArtist.getId();
        JSONObject relatedArtists = api.getRelatedArtists(topArtistId);
        JSONArray items = (JSONArray) relatedArtists.get("artists");
        List<String> listRelatedArtists = new ArrayList<>();
        for (int i = 0; (i < items.length() && i < 50); i++) {
            JSONObject currArtist = (JSONObject) items.get(i);
            listRelatedArtists.add((String) currArtist.get("name"));
        }
        return listRelatedArtists;
    }

    /**
     * Stores the user's API token inside our supersecret file.
     *
     * @param authCode is the authorization code from the redirect link.
     */
    @Override
    public void setToken( String authCode ) throws IOException {
        String token = api.getAuthorizationToken(authCode);

        File txtFile = new File("./supersecret.txt");

        // writing the token to the file:
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtFile));
        writer.write(token);
        writer.close();
    }

    /**
     * Gets the current user based on the token currently stored in our super
     * secret file.
     * @return the current user of the application.
     */
    @Override
    public String getCurrentUserId() throws IOException {
        User user = new User(api.getUserId());
        return user.getId();
    }
}
