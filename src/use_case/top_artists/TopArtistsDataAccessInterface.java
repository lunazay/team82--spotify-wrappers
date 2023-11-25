package use_case.top_artists;

import entity.Artist;

import java.io.IOException;

public interface TopArtistsDataAccessInterface {
    Artist[] getTopArtists(String id, String timeframe) throws Exception;
}
