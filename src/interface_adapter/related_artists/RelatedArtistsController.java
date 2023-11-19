package interface_adapter.related_artists;

import use_case.RelatedArtists.RelatedArtistsInputBoundary;
import use_case.RelatedArtists.RelatedArtistsInputData;

import java.io.IOException;

public class RelatedArtistsController {
    final RelatedArtistsInputBoundary relatedArtistsUseCaseInteractor;

    public RelatedArtistsController(RelatedArtistsInputBoundary relatedArtistsInputBoundary) {
        this.relatedArtistsUseCaseInteractor = relatedArtistsInputBoundary;
    }

    public void execute(String timeframe, String id) throws IOException {
        RelatedArtistsInputData relatedArtistsInputData = new RelatedArtistsInputData(timeframe, id);

        relatedArtistsUseCaseInteractor.execute(relatedArtistsInputData);
    }
}
