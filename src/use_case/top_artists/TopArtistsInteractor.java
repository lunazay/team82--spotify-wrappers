package use_case.top_artists;

import entity.Artist;

import java.util.ArrayList;
import java.util.List;

public class TopArtistsInteractor implements TopArtistsInputBoundary {
    final TopArtistsDataAccessInterface userDataAccessObject;
    final TopArtistsOutputBoundary topArtistPresenter;

    public TopArtistsInteractor(TopArtistsDataAccessInterface topArtistsDataAccessInterface,
                                TopArtistsOutputBoundary topArtistOutputBoundary) {
        this.userDataAccessObject = topArtistsDataAccessInterface;
        this.topArtistPresenter = topArtistOutputBoundary;
    }

    /**
     * Creates a list of the names of a user's top artists and passes it in to the TopArtistPresenter, if
     * there are top artists returned by the API call.
     * Otherwise, the presenter prepares the fail view.
     * @param topArtistsInputData contains the user id and timeframe to specify the API call
     */
    @Override
    public void execute(TopArtistsInputData topArtistsInputData) {
        String id = topArtistsInputData.getId();
        String timeframe = topArtistsInputData.getTimeframe();

        try {
            Artist[] topArtists = userDataAccessObject.getTopArtists(id, timeframe);
            List<String> topArtistNames = new ArrayList<String>(50);

            int i = 0;
            for (Artist artist : topArtists) {
                topArtistNames.set(i, artist.getName());
                i = i + 1;
            }

            TopArtistsOutputData topArtistsOutputData = new TopArtistsOutputData(topArtistNames, false);
            topArtistPresenter.prepareSuccessView(topArtistsOutputData);
        } catch (Exception e) {
            topArtistPresenter.prepareFailView("Listen to some music bro!");
        }
    }
}
