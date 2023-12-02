package interface_adapter.top_songs;

import interface_adapter.ViewManagerModel;
import use_case.top_songs.TopSongsOutputBoundary;
import use_case.top_songs.TopSongsOutputData;

public class TopSongsPresenter implements TopSongsOutputBoundary {
    private final TopSongsViewModel topSongsViewModel;
    private final ViewManagerModel viewManagerModel;

    public TopSongsPresenter(ViewManagerModel viewManagerModel,
                             TopSongsViewModel topSongsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topSongsViewModel = topSongsViewModel;
    }

    @Override
    public void prepareSuccessView(TopSongsOutputData topSongsOutputData) {
        TopSongsState topSongsState = topSongsViewModel.getState();
        topSongsState.setSongs(topSongsOutputData.getSongNames());
        topSongsViewModel.setState(topSongsState);
        topSongsViewModel.firePropertyChanged();

        viewManagerModel.setActiveViewName((topSongsViewModel.getViewName()));
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TopSongsState topSongsState = topSongsViewModel.getState();
        topSongsState.setSongsError(error);
        topSongsViewModel.setState(topSongsState);
        topSongsViewModel.firePropertyChanged();
    }
}
