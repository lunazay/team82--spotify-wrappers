package interface_adapter.top_artists;

import use_case.top_artists.TopArtistsInputBoundary;
import use_case.top_artists.TopArtistsInputData;

public class TopArtistsController {
    final TopArtistsInputBoundary topArtistsUseCaseInteractor;

    public TopArtistsController(TopArtistsInputBoundary topArtistsInputBoundary) {
        this.topArtistsUseCaseInteractor = topArtistsInputBoundary;
    }

    public void execute(String timeframe, String id) {

        TopArtistsInputData topArtistsInputData = new TopArtistsInputData(timeframe, id);

        topArtistsUseCaseInteractor.execute(topArtistsInputData);
    }
}
