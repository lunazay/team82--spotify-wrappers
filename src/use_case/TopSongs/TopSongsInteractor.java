package use_case.TopSongs;

import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class TopSongsInteractor implements TopSongsInputBoundary {

    final TopSongsDataAccessInterface userDataAccessObject;
    final TopSongsOutputBoundary topSongsPresenter;

    public TopSongsInteractor(TopSongsDataAccessInterface userDataAccessObject,
                              TopSongsOutputBoundary topSongsOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.topSongsPresenter = topSongsOutputBoundary;
    }

    @Override
    public void execute(TopSongsInputData topSongsInputData) {
        String id = topSongsInputData.getId();
        String timeframe = topSongsInputData.getTimeframe();

        try {
            Song[] topSongs = userDataAccessObject.getTopSongs(id, timeframe);
            List<String> topSongTitles = new ArrayList<String>(50);

            int i = 0;
            for (Song song : topSongs) {
                topSongTitles.set(i, song.getName());
                i = i + 1;
            }

            TopSongsOutputData topSongsOutputData = new TopSongsOutputData(id, topSongTitles, false);
            topSongsPresenter.prepareSuccessView(topSongsOutputData);
        } catch (Exception e) {
            topSongsPresenter.prepareFailView("Listen to some music bro!");
        }
    }
}
