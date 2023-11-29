package use_case.top_genre;
import entity.Genre;

import java.util.ArrayList;

public class TopGenreInteractor implements TopGenreInputBoundary {
    final TopGenreDataAccessInterface userDataAccessObject;
    final TopGenreOutputBoundary topGenrePresenter;

    public TopGenreInteractor(TopGenreDataAccessInterface userDataAccessObject, TopGenreOutputBoundary topGenrePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.topGenrePresenter = topGenrePresenter;

    }

    /**
     * Creates a list of the names of a user's top genre and passes it in to the TopGenrePresenter, if
     * there are top artists returned by the API call.
     * Otherwise, the presenter prepares the fail view.
     * @param topGenreInputData contains the user id and timeframe to specify the API call
     */

    @Override
    public void execute(TopGenreInputData topGenreInputData) {
        String id = topGenreInputData.getId();
        String timeframe = topGenreInputData.getTimeframe();

        try {
            ArrayList<Genre> topGenres = userDataAccessObject.getTopGenres(id, timeframe);
            ArrayList<String> topGenreTitles = new ArrayList<>(5);

            Integer genreNumber = 1;

            for (Genre genre : topGenres) {
                topGenreTitles.add(genreNumber + ". " + genre.getName());
                genreNumber ++;
            }

            TopGenreOutputData topGenreOutputData = new TopGenreOutputData(topGenreTitles, false, genreNumber);
            topGenrePresenter.prepareSuccessView(topGenreOutputData);
        } catch (Exception e) {
            topGenrePresenter.prepareFailView("Listen to some music bro!");

    }
}
}
