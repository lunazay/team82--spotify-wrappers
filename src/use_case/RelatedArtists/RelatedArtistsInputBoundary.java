package use_case.RelatedArtists;

import java.io.IOException;

public interface RelatedArtistsInputBoundary {
    void execute (RelatedArtistsInputData relatedArtistsInputData) throws IOException;
}
