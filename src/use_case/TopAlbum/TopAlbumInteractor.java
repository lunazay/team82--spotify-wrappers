package use_case.TopAlbum;
import entity.Song;

import java.util.ArrayList;
import java.util.List;

public class TopAlbumInteractor {
    final TopAlbumDataAccessinterface userDataAccessObject;
    final TopAlbumOutputBoundary topAlbumPresenter;

    public TopAlbumInteractor(TopAlbumDataAccessinterface userDataAccessObject,
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
            for (Song album : topAlbums) {
                topAlbumTitles.set(i, album.getAlbum());
                i = i + 1;
            }

            TopAlbumOutputData topAlbumOutputData = new TopAlbumOutputData(topAlbumTitles, false);
            topAlbumPresenter.prepareSuccessView(topAlbumOutputData);

        } catch (Exception e) {

            topAlbumPresenter.prepareFailView("Listen to some music bro!");

        }
    }
}
