package interface_adapter.top_genre;

import use_case.TopGenre.TopGenreInputBoundary;
import use_case.TopGenre.TopGenreInputData;

public class TopGenreController {
    final TopGenreInputBoundary userTopGenreUseCaseInteractor;

    public TopGenreController(TopGenreInputBoundary userTopGenreUseCaseInteractor) {
        this.userTopGenreUseCaseInteractor = userTopGenreUseCaseInteractor;
    }

    public void execute(String id, String timeframe){
        TopGenreInputData topGenreInputData = new TopGenreInputData(timeframe, id);
        userTopGenreUseCaseInteractor.execute(topGenreInputData);
    }
}
