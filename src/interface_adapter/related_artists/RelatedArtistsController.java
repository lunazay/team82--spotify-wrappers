package interface_adapter.related_artists;

import use_case.related_artists.RelatedArtistsInputBoundary;
import use_case.related_artists.RelatedArtistsInputData;


public class RelatedArtistsController {
    final RelatedArtistsInputBoundary relatedArtistsUseCaseInteractor;

    public RelatedArtistsController(RelatedArtistsInputBoundary relatedArtistsInputBoundary) {
        this.relatedArtistsUseCaseInteractor = relatedArtistsInputBoundary;
    }

    public void execute(String timeframe, String id) throws Exception {
        RelatedArtistsInputData relatedArtistsInputData = new RelatedArtistsInputData(timeframe, id);

        relatedArtistsUseCaseInteractor.execute(relatedArtistsInputData);
    }
}
