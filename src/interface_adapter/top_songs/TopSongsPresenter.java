package interface_adapter.top_songs;

import interface_adapter.ViewManagerModel;
import use_case.TopSongs.TopSongsOutputBoundary;
import use_case.TopSongs.TopSongsOutputData;

public class TopSongsPresenter implements TopSongsOutputBoundary {
    private final TopSongsViewModel topSongsViewModel;
    private ViewManagerModel viewManagerModel;

    public TopSongsPresenter(ViewManagerModel viewManagerModel,
                             TopSongsViewModel topSongsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topSongsViewModel = topSongsViewModel;
    }

    @Override
    public void prepareSuccessView(TopSongsOutputData topSongsOutputData) {
        // TODO: implement me!
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: implement me!
    }
}
