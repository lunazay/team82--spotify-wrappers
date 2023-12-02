package interface_adapter.related_artists;

import interface_adapter.ViewManagerModel;
import use_case.related_artists.RelatedArtistsOutputBoundary;
import use_case.related_artists.RelatedArtistsOutputData;

public class RelatedArtistsPresenter implements RelatedArtistsOutputBoundary {
    private final RelatedArtistsViewModel relatedArtistsViewModel;
    private final ViewManagerModel viewManagerModel;

    public RelatedArtistsPresenter(ViewManagerModel viewManagerModel,
                                   RelatedArtistsViewModel relatedArtistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.relatedArtistsViewModel = relatedArtistsViewModel;
    }

    /**
     * Updates the view with the list of RelatedArtists received.
     *
     * @param artists Stores the list of the names of the top artist's related artists.
     */
    @Override
    public void prepareSuccessView(RelatedArtistsOutputData artists) {
        RelatedArtistsState relatedArtistsState = relatedArtistsViewModel.getState();
        relatedArtistsState.setRelatedArtists(artists.getRelatedArtists());
        relatedArtistsViewModel.setState(relatedArtistsState);
        relatedArtistsViewModel.firePropertyChanged();

        viewManagerModel.setActiveViewName(relatedArtistsViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        RelatedArtistsState relatedArtistsState = relatedArtistsViewModel.getState();
        relatedArtistsState.setRelatedArtistsError(error);
        relatedArtistsViewModel.setState(relatedArtistsState);
        relatedArtistsViewModel.firePropertyChanged();
    }
}
