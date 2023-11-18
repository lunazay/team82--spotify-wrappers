package data_access;

import api.DevelopDB;
import api.SpotDevelopDB;
import entity.Song;
import entity.Genre;
import use_case.GetValence.GetValenceDataAccessInterface;
import use_case.TopGenre.TopGenreDataAccessInterface;
import use_case.TopSongs.TopSongsDataAccessInterface;

import java.util.ArrayList;

public class UserDataAccessObject implements TopSongsDataAccessInterface, TopGenreDataAccessInterface,
        GetValenceDataAccessInterface {

    private final DevelopDB api = new SpotDevelopDB();

    @Override
    public Song[] getTopSongs(String id, String timeframe) {
        // TODO: Implement me!
        //return new Song[0];
        return null;
    }

    @Override
    public Genre[] getTopGenres(String id, String timeframe){
        // TODO: implement me!
        return new Genre[0];
    }

    public String getValence(String id, String timeframe) {

        Song[] songs = getTopSongs(id, timeframe);

        ArrayList<String> songIds = new ArrayList<>();

        for (Song song : songs) { songIds.add(song.getId()); }

        return api.get_valence(songIds);
    }
}
