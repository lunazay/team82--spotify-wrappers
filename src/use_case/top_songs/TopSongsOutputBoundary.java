package use_case.top_songs;

public interface TopSongsOutputBoundary {

    /**
     * Updates the view with the list of TopAlbums received.
     *
     * @param user Stores the list of the names of the user's top songs.
     */
    void prepareSuccessView(TopSongsOutputData user);

    /**
     * Updates the view with an error to be displayed.
     *
     * @param error The error to show to the user
     */
    void prepareFailView(String error);
}
