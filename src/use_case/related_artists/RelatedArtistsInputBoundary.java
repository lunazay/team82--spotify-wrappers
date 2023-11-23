package use_case.related_artists;

import java.io.IOException;

public interface RelatedArtistsInputBoundary {
    void execute (RelatedArtistsInputData relatedArtistsInputData) throws IOException;
}
