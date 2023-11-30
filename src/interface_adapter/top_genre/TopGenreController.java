package interface_adapter.top_genre;

import use_case.top_genre.TopGenreInputBoundary;
import use_case.top_genre.TopGenreInputData;

public class TopGenreController {
    private final TopGenreInputBoundary userTopGenreUseCaseInteractor;

    public TopGenreController(TopGenreInputBoundary userTopGenreUseCaseInteractor) {
        this.userTopGenreUseCaseInteractor = userTopGenreUseCaseInteractor;
    }

    public void execute(String timeframe, String id){
        // TopGenreState topGenreState = new TopGenreState();
        // String timeframe = topGenreState.getTimeframe();
        TopGenreInputData topGenreInputData = new TopGenreInputData(timeframe, id);
        userTopGenreUseCaseInteractor.execute(topGenreInputData);
    }
}
