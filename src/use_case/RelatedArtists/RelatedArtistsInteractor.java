package use_case.RelatedArtists;

import use_case.TopSongs.TopSongsOutputBoundary;

public class RelatedArtistsInteractor implements RelatedArtistsInputBoundary{
    final RelatedArtistsDataAccessInterface userDataAccessObject;
    final RelatedArtistsOutputBoundary relatedArtistsPresenter;

    public RelatedArtistsInteractor(RelatedArtistsDataAccessInterface userDataAccessObject, RelatedArtistsOutputBoundary relatedArtistsOutputBoundary){
        this.userDataAccessObject = userDataAccessObject;
        this.relatedArtistsPresenter = relatedArtistsOutputBoundary;
    }
    @Override
    public void execute(RelatedArtistsInputData relatedArtistsInputData) {
        String id = relatedArtistsInputData.getId();
        String timeframe = relatedArtistsInputData.getTimeframe();
        // TODO: finish this
    }
}
