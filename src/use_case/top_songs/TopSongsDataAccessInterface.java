package use_case.top_songs;

import entity.Song;

public interface TopSongsDataAccessInterface {
    Song[] getTopSongs(String id, String timeframe) throws Exception;
}
