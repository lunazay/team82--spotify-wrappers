package data_access;

import entity.Song;
import entity.Genre;
import use_case.TopGenre.TopGenreDataAccessInterface;
import use_case.TopSongs.TopSongsDataAccessInterface;

public class UserDataAccessObject implements TopSongsDataAccessInterface, TopGenreDataAccessInterface {

    @Override
    public Song[] getTopSongs(String id, String timeframe) {
        // TODO: Implement me!
        return new Song[0];
    }

    @Override
    public Genre[] getTopGenres(String id, String timeframe){
        // TODO: implement me!
        return new Genre[0];
        // top 5 genres
    }
}
