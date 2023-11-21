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

    /**
     * Creates a list of the titles of a user's top songs and passes it in to the TopSongsPresenter, if
     * there are top songs returned by the API call.
     * Otherwise, the presenter prepares the fail view.
     * @param topSongsInputData contains the user id and timeframe to specify the API call
     */
    @Override
    public void execute(TopSongsInputData topSongsInputData) {
        String id = topSongsInputData.getId();
        String timeframe = topSongsInputData.getTimeframe();

        try {
            Song[] topSongs = userDataAccessObject.getTopSongs(id, timeframe);
            List<String> topSongTitles = new ArrayList<String>(50);

            Integer songNumber = 1;

            for (Song song : topSongs) {
                topSongTitles.add(songNumber + ". " + song.getName()); // Concatenate song number with song name
                songNumber++; // Increment the song number for the next iteration
            }

            TopSongsOutputData topSongsOutputData = new TopSongsOutputData(topSongTitles, false, songNumber);
            topSongsPresenter.prepareSuccessView(topSongsOutputData);
        } catch (Exception e) {
            topSongsPresenter.prepareFailView("Listen to some music bro!");
        }
    }
}
