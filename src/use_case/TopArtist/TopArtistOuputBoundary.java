package use_case.TopArtist;

public interface TopArtistOuputBoundary {
    void prepareSuccessView(TopArtistOutputData user);

    void prepareFailView(String error);
}
