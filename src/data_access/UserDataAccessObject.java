package data_access;

import api.DevelopDB;
import api.SpotDevelopDB;
import entity.Artist;
import entity.Song;
import entity.Genre;
import use_case.get_valence.GetValenceDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.related_artists.RelatedArtistsDataAccessInterface;
import use_case.top_album.TopAlbumDataAccessInterface;
import use_case.top_artists.TopArtistsDataAccessInterface;
import use_case.top_genre.TopGenreDataAccessInterface;
import use_case.top_songs.TopSongsDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDataAccessObject implements TopSongsDataAccessInterface, TopGenreDataAccessInterface,
        GetValenceDataAccessInterface, RelatedArtistsDataAccessInterface, TopArtistsDataAccessInterface, TopAlbumDataAccessInterface,
        LoginUserDataAccessInterface {

    private final DevelopDB api = new SpotDevelopDB();

    @Override
    public Song[] getTopSongs(String id, String timeframe) {
        // TODO: Implement me!
        //return new Song[0];
        return null;
    }

    @Override
    public ArrayList<Genre> getTopGenres(String id, String timeframe) throws IOException {
        Artist[] topArtist = getTopArtists(id, timeframe);
        ArrayList<Genre> topGenres = new ArrayList<Genre>();
        int count = 0;
        for (Artist artist: topArtist){
            // i want to return an array list of Genre objects becuase that is how we
            // decided our design implementaiton will be
            Genre[] genres = artist.getGenres();
            Genre topGenre = genres[0];
            topGenres.add(topGenre);
            count++;
            // since i only want the top 5 genres, im only counting till 5
            if (count >= 5) {
                break;
            }
        }
        return topGenres;
    }

    @Override
    public Song[] getTopAlbums(String id, String timeframe){
        //TODO: implement me!
        return null;
    }

    /**
     * Makes an API call to get a user's top artists over a desired timeframe.
     * @param id        the user's Spotify id
     * @param timeframe the API call time_range (short_term: 4 weeks, medium_term: 6 months, long_term: all time)
     * @return          an ArrayList of the user's top artists, as Artist objects
     */
    @Override
    public Artist[] getTopArtists(String id, String timeframe) throws IOException {
        Artist[] artists = api.getTopArtists(timeframe);

        if (artists.length > 0) {
            return artists;
        }

        return null;
    }

    @Override
    public String getValence(String id, String timeframe) throws IOException {

        Song[] songs = getTopSongs(id, timeframe);

        double valence_sum = 0;
        int num_elements = 0;

        // calculating the mean valence:
        for (Song song : songs) {

            double valence = Double.parseDouble(api.get_valence(song.getId()));
            valence_sum += valence;

            num_elements++;

        }

        // mean is sum / total, where total is greater than 0
        if (num_elements > 0) { return String.valueOf(valence_sum / num_elements); }

        // if user has listened to no songs, then we obviously can't return a value for valence
        return "null";

    }

    @Override
    public List<String> getRelatedArtists(String id, String timeframe) throws IOException {
        Artist topArtist = getTopArtists(id, timeframe)[0];
        return topArtist.getRelatedArtists();
    }

    @Override
    public void setToken( String authCode ) throws IOException {

        String token = api.getAuthorizationToken(authCode);

        File txtFile = new File("./supersecret.txt");

        // writing the token to the file:
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtFile));
        writer.write(token);
        writer.close();
    }
}
