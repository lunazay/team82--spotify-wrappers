package interface_adapter.top_album;

import use_case.TopAlbum.TopAlbumInputBoundary;
import use_case.TopAlbum.TopAlbumInputData;

public class TopAlbumController {
    final TopAlbumInputBoundary topAlbumUseCaseInteractor;

    public TopAlbumController(TopAlbumInputBoundary topAlbumInputBoundary) {
        this.topAlbumUseCaseInteractor = topAlbumInputBoundary;
    }

    public void execute(String timeframe, String id) {
        TopAlbumInputData topAlbumInputData = new TopAlbumInputData(timeframe, id);

        topAlbumUseCaseInteractor.execute(topAlbumInputData);
    }
}
