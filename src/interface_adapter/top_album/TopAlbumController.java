package interface_adapter.top_album;

import use_case.top_album.TopAlbumInputBoundary;
import use_case.top_album.TopAlbumInputData;

public class TopAlbumController {
    final TopAlbumInputBoundary topAlbumUseCaseInteractor;

    public TopAlbumController(TopAlbumInputBoundary topAlbumInputBoundary) {
        this.topAlbumUseCaseInteractor = topAlbumInputBoundary;
    }

    public void execute( String id) {
        TopAlbumState topAlbumState = new TopAlbumState();
        String timeframe = topAlbumState.getTimeframe();
        TopAlbumInputData topAlbumInputData = new TopAlbumInputData(timeframe, id);

        topAlbumUseCaseInteractor.execute(topAlbumInputData);
    }
}
