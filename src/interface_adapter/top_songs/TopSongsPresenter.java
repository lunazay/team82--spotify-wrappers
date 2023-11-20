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
        TopSongsState topSongsState = topSongsViewModel.getState();
        topSongsState.setId(topSongsState.getId()); // is this line necessary?
        topSongsViewModel.firePropertyChanged();
        viewManagerModel.setActiveViewName((topSongsViewModel.getViewName()));
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TopSongsState topSongsState = topSongsViewModel.getState();
        // TODO: actually implement the fail view
        topSongsViewModel.firePropertyChanged();
    }
}
