package use_case.related_artists;

import java.util.List;

import java.io.IOException;

public class RelatedArtistsInteractor implements RelatedArtistsInputBoundary{
    final RelatedArtistsDataAccessInterface userDataAccessObject;
    final RelatedArtistsOutputBoundary relatedArtistsPresenter;

    public RelatedArtistsInteractor(RelatedArtistsDataAccessInterface userDataAccessObject, RelatedArtistsOutputBoundary relatedArtistsOutputBoundary){
        this.userDataAccessObject = userDataAccessObject;
        this.relatedArtistsPresenter = relatedArtistsOutputBoundary;
    }
    /**
     * Creates a list of the names of a top artist's related artists and passes it in to the RelatedArtistsPresenter, if
     * there are top artist's related artists returned by the API call.
     * Otherwise, the presenter prepares the fail view.
     * @param relatedArtistsInputData contains the top artist's id and timeframe to specify the API call.
     */
    @Override
    public void execute(RelatedArtistsInputData relatedArtistsInputData) throws IOException {
        String id = relatedArtistsInputData.getId();
        String timeframe = relatedArtistsInputData.getTimeframe();
        try {
            List<String> relatedArtists = userDataAccessObject.getRelatedArtists(id, timeframe);
            RelatedArtistsOutputData relatedArtistsOutputData = new RelatedArtistsOutputData(relatedArtists, false);
            relatedArtistsPresenter.prepareSuccessView(relatedArtistsOutputData);

        } catch (Exception e) {
            relatedArtistsPresenter.prepareFailView("Listen to some music bro!");
        }
    }
}
