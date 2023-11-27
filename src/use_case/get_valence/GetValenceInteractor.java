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
    public void execute(GetValenceInputData getValenceInputData) throws Exception {

        String id = getValenceInputData.getId();

        String timeframe = getValenceInputData.getTimeframe();

        // uses the data access object to access the data:

        try {
            String valence = getValenceDataAccessObject.getValence(id, timeframe);
            GetValenceOutputData getValenceOutputData = new GetValenceOutputData(valence);
            getValencePresenter.prepareSuccessView(getValenceOutputData);
        } catch (Exception e) {
            getValencePresenter.prepareFailView("Listen to some music bro!");
        }

    }
}
