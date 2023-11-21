package use_case.RelatedArtists;

import entity.Artist;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class RelatedArtistsInteractor implements RelatedArtistsInputBoundary{
    final RelatedArtistsDataAccessInterface userDataAccessObject;
    final RelatedArtistsOutputBoundary relatedArtistsPresenter;

    public RelatedArtistsInteractor(RelatedArtistsDataAccessInterface userDataAccessObject, RelatedArtistsOutputBoundary relatedArtistsOutputBoundary){
        this.userDataAccessObject = userDataAccessObject;
        this.relatedArtistsPresenter = relatedArtistsOutputBoundary;
    }
    @Override
    public void execute(RelatedArtistsInputData relatedArtistsInputData) throws IOException {
        String id = relatedArtistsInputData.getId();
        String timeframe = relatedArtistsInputData.getTimeframe();
        try {
            List<String> relatedArtists = userDataAccessObject.getRelatedArtists(id, timeframe);
            RelatedArtistsOutputData relatedArtistsOutputData = new RelatedArtistsOutputData(relatedArtists, false);
            relatedArtistsPresenter.prepareSuccessView(relatedArtistsOutputData);
        } catch (IOException e) {
            relatedArtistsPresenter.prepareFailView("Listen to some music!");
        }
    }
}
