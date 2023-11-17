package use_case.TopArtist;

import entity.Artist;
import entity.Song;
import use_case.TopSongs.TopSongsOutputData;

import java.util.ArrayList;
import java.util.List;

public class TopArtistInteractor implements TopArtistInputBoundary {
    final TopArtistDataAccessInterface userDataAccessObject;
    final TopArtistOuputBoundary topArtistPresenter;

    public TopArtistInteractor(TopArtistDataAccessInterface topArtistDataAccessInterface,
                               TopArtistOuputBoundary topArtistOutputBoundary) {
        this.userDataAccessObject = topArtistDataAccessInterface;
        this.topArtistPresenter = topArtistOutputBoundary;
    }

    /**
     * Creates a list of the names of a user's top artists and passes it in to the TopArtistPresenter, if
     * there are top artists returned by the API call.
     * Otherwise, the presenter prepares the fail view.
     * @param topArtistInputData contains the user id and timeframe to specify the API call
     */
    @Override
    public void execute(TopArtistInputData topArtistInputData) {
        String id = topArtistInputData.getId();
        String timeframe = topArtistInputData.getTimeframe();

        try {
            Artist[] topArtists = userDataAccessObject.getTopArtists(id, timeframe);
            List<String> topArtistNames = new ArrayList<String>(50);

            int i = 0;
            for (Artist artist : topArtists) {
                topArtistNames.set(i, artist.getName());
                i = i + 1;
            }

            TopArtistOutputData topArtistOutputData = new TopArtistOutputData(topArtistNames, false);
            topArtistPresenter.prepareSuccessView(topArtistOutputData);
        } catch (Exception e) {
            topArtistPresenter.prepareFailView("Listen to some music bro!");
        }
    }
}
