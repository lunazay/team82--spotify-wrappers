package interface_adapter.top_genre;

import interface_adapter.ViewManagerModel;
import use_case.TopGenre.TopGenreOutputBoundary;
import use_case.TopGenre.TopGenreOutputData;

public class TopGenrePresenter implements TopGenreOutputBoundary {

    private final TopGenreViewModel topGenreViewModel;
    private final ViewManagerModel viewManagerModel;

    public TopGenrePresenter(TopGenreViewModel topGenreViewModel, ViewManagerModel viewManagerModel) {
        this.topGenreViewModel = topGenreViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TopGenreOutputData user) {
        TopGenreState topGenreState = topGenreViewModel.getState();
        topGenreState.setId(topGenreState.getId());
        topGenreViewModel.firePropertyChanged();
        viewManagerModel.setActiveViewName((topGenreViewModel.getViewName()));
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TopGenreState topGenreState = topGenreViewModel.getState();
        // TODO: actually implement the fail view
        topGenreViewModel.firePropertyChanged();
    }
}
