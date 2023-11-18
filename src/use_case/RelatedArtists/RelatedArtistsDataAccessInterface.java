package use_case.RelatedArtists;
import entity.Artist;

public interface RelatedArtistsDataAccessInterface {
    Artist[] getRelatedArtists(String id, String timeframe);
}
