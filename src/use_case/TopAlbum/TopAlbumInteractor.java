package use_case.TopAlbum;
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

    @Override
    public void execute(TopAlbumInputData topAlbumInputData) {
        String id = topAlbumInputData.getId();
        String timeframe = topAlbumInputData.getTimeframe();

        try {
            Song[] topAlbums = userDataAccessObject.getTopAlbums(id, timeframe);
            List<String> topAlbumTitles = new ArrayList<String>(50);

            int i = 0;
            for (Song song : topAlbums) {
                topAlbumTitles.set(i, song.getAlbum());
                i = i + 1;
            }

            TopAlbumOutputData topAlbumOutputData = new TopAlbumOutputData(topAlbumTitles, false);
            topAlbumPresenter.prepareSuccessView(topAlbumOutputData);

        } catch (Exception e) {

            topAlbumPresenter.prepareFailView("Listen to some music bro!");

        }
    }
}
