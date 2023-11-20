package interface_adapter.top_artists;

import interface_adapter.ViewManagerModel;
import use_case.top_artists.TopArtistsOutputBoundary;
import use_case.top_artists.TopArtistsOutputData;

public class TopArtistsPresenter implements TopArtistsOutputBoundary {
    private final TopArtistsViewModel topArtistsViewModel;
    private ViewManagerModel viewManagerModel;

    public TopArtistsPresenter(ViewManagerModel viewManagerModel,
                               TopArtistsViewModel topArtistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topArtistsViewModel = topArtistsViewModel;
    }

    /**
     * Updates the view with the list of TopArtists received.
     *
     * @param artists Stores the list of the names of the user's top artists.
     */
    @Override
    public void prepareSuccessView(TopArtistsOutputData artists) {
        // Updates the current TopArtistsState with the list of the user's top artists.
        TopArtistsState topArtistsState = topArtistsViewModel.getState();
        topArtistsState.setArtistNames(artists.getArtistNames());
        this.topArtistsViewModel.setState(topArtistsState);
        topArtistsViewModel.firePropertyChanged();

        // Changes the view to reflect updates.
        viewManagerModel.setActiveView(topArtistsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Updates the view with an error to be displayed.
     *
     * @param error The error to show to the user.
     */
    @Override
    public void prepareFailView(String error) {
        TopArtistsState topArtistsState = topArtistsViewModel.getState();
        topArtistsState.setArtistNamesError(error);
        topArtistsViewModel.firePropertyChanged();
    }
}
