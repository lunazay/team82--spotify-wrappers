package use_case.related_artists;


import java.util.List;

import java.io.IOException;

public interface RelatedArtistsDataAccessInterface {
    List<String> getRelatedArtists(String id, String timeframe) throws Exception;
}
