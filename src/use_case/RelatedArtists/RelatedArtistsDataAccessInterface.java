package use_case.RelatedArtists;

import entity.Artist;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

public interface RelatedArtistsDataAccessInterface {
    List<String> getRelatedArtists(String id, String timeframe) throws IOException;
}
