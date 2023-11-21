package use_case.RelatedArtists;


import java.util.List;

import java.io.IOException;

public interface RelatedArtistsDataAccessInterface {
    List<String> getRelatedArtists(String id, String timeframe) throws IOException;
}
