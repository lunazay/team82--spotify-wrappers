package interface_adapter.related_artists;

import use_case.related_artists.RelatedArtistsInputBoundary;
import use_case.related_artists.RelatedArtistsInputData;

import java.io.IOException;

public class RelatedArtistsController {
    final RelatedArtistsInputBoundary relatedArtistsUseCaseInteractor;

    public RelatedArtistsController(RelatedArtistsInputBoundary relatedArtistsInputBoundary) {
        this.relatedArtistsUseCaseInteractor = relatedArtistsInputBoundary;
    }

    public void execute( String id) throws Exception {
        RelatedArtistsState relatedArtistsState = new RelatedArtistsState();
        String timeframe= relatedArtistsState.getTimeframe();
        RelatedArtistsInputData relatedArtistsInputData = new RelatedArtistsInputData(timeframe, id);

        relatedArtistsUseCaseInteractor.execute(relatedArtistsInputData);
    }
}
