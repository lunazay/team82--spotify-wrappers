package use_case.top_album;
import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class TopAlbumInteractor implements TopAlbumInputBoundary{
    final TopAlbumDataAccessInterface userDataAccessObject;
    final TopAlbumOutputBoundary topAlbumPresenter;

    public TopAlbumInteractor(TopAlbumDataAccessInterface userDataAccessObject,
                              TopAlbumOutputBoundary topAlbumOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.topAlbumPresenter = topAlbumOutputBoundary;
    }

    /**
     * Creates a list of the names of a user's top albums and passes it in to the TopAlbumPresenter, if
     * there are top albums returned by the API call.
     * Otherwise, the presenter prepares the fail view.
     * @param topAlbumInputData contains the user id and timeframe to specify the API call
     */
    @Override
    public void execute(TopAlbumInputData topAlbumInputData) {
        String id = topAlbumInputData.getId();
        String timeframe = topAlbumInputData.getTimeframe();

        try {
            List<String> topAlbums = userDataAccessObject.getTopAlbums(id, timeframe);
            List<String> topAlbumTitles = new ArrayList<String>(50);

            int i = 0;
            for (String song : topAlbums) {
                topAlbumTitles.set(i, song.getAlbum()); // TODO: fix error
                i = i + 1;
            }

            TopAlbumOutputData topAlbumOutputData = new TopAlbumOutputData(topAlbumTitles, false);
            topAlbumPresenter.prepareSuccessView(topAlbumOutputData);

        } catch (Exception e) {

            topAlbumPresenter.prepareFailView("Listen to some music bro!");

        }
    }
}
