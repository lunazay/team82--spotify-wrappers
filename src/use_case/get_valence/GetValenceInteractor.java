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

    /**
     * Gets the valence of the user's top songs and passes it in to the getValencePresenter, if
     * the user has listened to any songs.
     * Otherwise, the presenter prepares the fail view.
     * @param getValenceInputData contains the user id and timeframe to specify the API call.
     */
    @Override
    public void execute(GetValenceInputData getValenceInputData) throws Exception {
        // getting the id and the timeframe from our input data:
        String id = getValenceInputData.getId();
        String timeframe = getValenceInputData.getTimeframe();

        try {  // uses the data access object to access the data:
            String valence = getValenceDataAccessObject.getValence(id, timeframe);
            GetValenceOutputData getValenceOutputData = new GetValenceOutputData(valence);
            getValencePresenter.prepareSuccessView(getValenceOutputData);
        } catch (Exception e) {
            getValencePresenter.prepareFailView(e.getMessage());
        }

    }
}
