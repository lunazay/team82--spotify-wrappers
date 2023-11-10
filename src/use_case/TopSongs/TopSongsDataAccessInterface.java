package use_case.TopSongs;

import entity.Song;

public interface TopSongsDataAccessInterface {
    Song[] getTopSongs(String id, String timeframe);
}
