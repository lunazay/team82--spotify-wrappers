package use_case.get_valence;

import java.io.IOException;

public class GetValenceInteractor implements GetValenceInputBoundary{

    final GetValenceDataAccessInterface getValenceDataAccessObject;

    final GetValenceOutputBoundary getValencePresenter;

    public GetValenceInteractor(GetValenceDataAccessInterface getValenceDataAccessInterface,
                                GetValenceOutputBoundary getValencePresenter) {
        this.getValenceDataAccessObject = getValenceDataAccessInterface;
        this.getValencePresenter = getValencePresenter;
    }

    @Override
    public void execute(GetValenceInputData getValenceInputData) throws IOException {

        String id = getValenceInputData.getId();

        String timeframe = getValenceInputData.getTimeframe();

        // uses the data access object to access the data:
        String valence = getValenceDataAccessObject.getValence(id, timeframe);

        // creating a new output data object with the valence & creating a
        // sucess view using it
        GetValenceOutputData getValenceOutputData = new GetValenceOutputData(valence);
        getValencePresenter.prepareSuccessView(getValenceOutputData);

    }
}
