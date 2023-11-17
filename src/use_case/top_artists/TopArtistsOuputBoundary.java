package use_case.top_artists;

public interface TopArtistsOuputBoundary {
    void prepareSuccessView(TopArtistsOutputData user);

    void prepareFailView(String error);
}
