package use_case.GetValence;

import entity.Song;

public class GetValenceInteractor implements GetValenceInputBoundary{

    final GetValenceDataAccessInterface getValenceDataAccessObject;

    final GetValenceOutputBoundary getValencePresenter;

    public GetValenceInteractor(GetValenceDataAccessInterface getValenceDataAccessInterface,
                                GetValenceOutputBoundary getValencePresenter) {
        this.getValenceDataAccessObject = getValenceDataAccessInterface;
        this.getValencePresenter = getValencePresenter;
    }

    public void execute() {

        String valence = getValenceDataAccessObject.getValence(id, timeframe);
        GetValenceOutputData getValenceOutputData = new GetValenceOutputData(valence);
        getValencePresenter.prepareSuccessView(getValenceOutputData);

    }
}
