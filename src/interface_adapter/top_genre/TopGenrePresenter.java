package interface_adapter.top_genre;

import interface_adapter.ViewManagerModel;
import use_case.top_genre.TopGenreOutputBoundary;
import use_case.top_genre.TopGenreOutputData;

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
        topGenreState.setGenres(user.getGenreNames());
        topGenreViewModel.setState(topGenreState);
        topGenreViewModel.setgenres(user.getGenreNames());
        topGenreViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        TopGenreState topGenreState = topGenreViewModel.getState();
        topGenreState.setError("Listen to some music bro!");
        topGenreViewModel.firePropertyChanged();
    }
}
