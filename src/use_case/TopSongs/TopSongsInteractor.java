package use_case.TopSongs;

import entity.Song;

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


            TopSongsOutputData topSongsOutputData = new TopSongsOutputData();
            topSongsPresenter.prepareSuccessView(topSongsOutputData);
        } catch (Exception e) {
            topSongsPresenter.prepareFailView("Listen to some music bro!");
        }
    }
}
