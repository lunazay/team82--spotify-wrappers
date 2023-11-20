package use_case.RelatedArtists;
import entity.Artist;

import java.io.IOException;

public interface RelatedArtistsDataAccessInterface {
    Artist[] getRelatedArtists(String id, String timeframe) throws IOException;
}
