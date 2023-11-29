package interface_adapter.top_songs;

import use_case.top_songs.TopSongsInputBoundary;
import use_case.top_songs.TopSongsInputData;

public class TopSongsController {
    final TopSongsInputBoundary topSongsUseCaseInteractor;

    public TopSongsController(TopSongsInputBoundary topSongsInputBoundary) {
        this.topSongsUseCaseInteractor = topSongsInputBoundary;
    }

    public void execute( String id) {
        TopSongsState topSongsState = new TopSongsState();
        String timeframe = topSongsState.getTimeframe();
        TopSongsInputData topSongsInputData = new TopSongsInputData(timeframe, id);

        topSongsUseCaseInteractor.execute(topSongsInputData);
    }
}
