package data_access;

import entity.Song;
import use_case.TopSongs.TopSongsDataAccessInterface;

public class UserDataAccessObject implements TopSongsDataAccessInterface {

    @Override
    public Song[] getTopSongs(String id, String timeframe) {
        // TODO: Implement me!
        return new Song[0];
    }
}
