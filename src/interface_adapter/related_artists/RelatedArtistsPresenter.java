package interface_adapter.related_artists;

import interface_adapter.ViewManagerModel;
import use_case.RelatedArtists.RelatedArtistsOutputBoundary;
import use_case.RelatedArtists.RelatedArtistsOutputData;

public class RelatedArtistsPresenter implements RelatedArtistsOutputBoundary {
    private final RelatedArtistsViewModel relatedArtistsViewModel;
    private ViewManagerModel viewManagerModel;

    public RelatedArtistsPresenter(ViewManagerModel viewManagerModel,
                                   RelatedArtistsViewModel relatedArtistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.relatedArtistsViewModel = relatedArtistsViewModel;
    }

    @Override
    public void prepareSuccessView(RelatedArtistsOutputData response) {
        RelatedArtistsState relatedArtistsState = relatedArtistsViewModel.getState();
        relatedArtistsState.setRelatedArtists(response.getRelatedArtists());
    }

    @Override
    public void prepareFailView(String error) {
        RelatedArtistsState relatedArtistsState = relatedArtistsViewModel.getState();
        relatedArtistsState.setError(error);
    }
}
