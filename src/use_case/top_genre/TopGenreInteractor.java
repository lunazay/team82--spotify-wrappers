package use_case.top_genre;
import entity.Genre;
import entity.Song;
import use_case.top_songs.TopSongsInputData;
import use_case.top_songs.TopSongsOutputData;

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
            List<String> topGenreTitles = new ArrayList<String>(5);

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
