package use_case.top_artists;

import entity.Artist;

public interface TopArtistsDataAccessInterface {
    Artist[] getTopArtists(String id, String timeframe);
}
