package interface_adapter.top_songs;

import interface_adapter.ViewManagerModel;
import interface_adapter.top_genre.TopGenreState;
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
        TopGenreState topGenreState = topSongsViewModel.getState();
        topGenreState.setId(topGenreState.getId()); // is this line necessary?
        topSongsViewModel.firePropertyChanged();
        viewManagerModel.setActiveViewName((topSongsViewModel.getViewName()));
        viewManagerModel.firePropertyChanged();
        // TODO: implement me!
    }

    @Override
    public void prepareFailView(String error) {
        // TODO: implement me!
    }
}
