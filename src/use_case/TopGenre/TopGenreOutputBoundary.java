package use_case.TopGenre;

public interface TopGenreOutputBoundary {
    void prepareSuccessView(TopGenreOutputData user);
    void prepareFailView(String error);

}
