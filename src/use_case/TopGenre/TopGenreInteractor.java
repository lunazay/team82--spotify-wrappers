package use_case.TopGenre;
import entity.Genre;
import java.util.ArrayList;
import java.util.List;

public class TopGenreInteractor implements TopGenreInputBoundary {
    final TopGenreDataAccessInterface userDataAccessObject;
    final TopGenreOutputBoundary topGenrePresenter;

    public TopGenreInteractor(TopGenreDataAccessInterface userDataAccessObject, TopGenreOutputBoundary topGenrePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.topGenrePresenter = topGenrePresenter;

    }

    @Override
    public void execute(TopGenreInputData topGenreInputData) {
        String id = topGenreInputData.getId();
        String timeframe = topGenreInputData.getTimeframe();

        try {
            ArrayList<Genre> topGenres = userDataAccessObject.getTopGenres(id, timeframe);
            List<String> topGenreTitles = new ArrayList<String>(50);

            int i = 0;
            for (Genre genre : topGenres) {
                topGenreTitles.set(i, genre.getName());
                i = i + 1;
            }

            TopGenreOutputData topGenreOutputData = new TopGenreOutputData(topGenreTitles, false);
            topGenrePresenter.prepareSuccessView(topGenreOutputData);
        } catch (Exception e) {
            topGenrePresenter.prepareFailView("Listen to some music bro!");

    }
}
}
