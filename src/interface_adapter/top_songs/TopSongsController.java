package interface_adapter.top_songs;

import use_case.TopSongs.TopSongsInputBoundary;
import use_case.TopSongs.TopSongsInputData;

public class TopSongsController {
    final TopSongsInputBoundary topSongsUseCaseInteractor;

    public TopSongsController(TopSongsInputBoundary topSongsInputBoundary) {
        this.topSongsUseCaseInteractor = topSongsInputBoundary;
    }

    public void execute(String timeframe, String id) {
        TopSongsInputData topSongsInputData = new TopSongsInputData(timeframe, id);

        topSongsUseCaseInteractor.execute(topSongsInputData);
    }
}
