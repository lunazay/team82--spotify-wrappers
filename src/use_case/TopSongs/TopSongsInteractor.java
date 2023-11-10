package use_case.TopSongs;

public class TopSongsInteractor implements TopSongsInputBoundary {

    final TopSongsDataAccessInterface userDataAccessObject;
    final TopSongsOutputBoundary topSongsPresenter;

    public TopSongsInteractor(TopSongsDataAccessInterface userDataAccessObject,
                              TopSongsOutputBoundary topSongsOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.topSongsPresenter = topSongsOutputBoundary;
    }

    @Override
    public void execute(TopSongsInputData topSongsInputData) {
        if (topSongsInputData == null) {
            topSongsPresenter.prepareFailView("nothing");
        }
        else {
            TopSongsOutputData topSongsOutputData = new TopSongsOutputData();
            topSongsPresenter.prepareSuccessView(topSongsOutputData);
        }
    }
}
