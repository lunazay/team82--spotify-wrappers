package use_case.related_artists;


import java.util.List;


public interface RelatedArtistsDataAccessInterface {
    List<String> getRelatedArtists(String id, String timeframe) throws Exception;
}
