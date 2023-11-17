package use_case.TopArtist;

import entity.Artist;

public interface TopArtistDataAccessInterface {
    Artist[] getTopArtists(String id, String timeframe);
}
