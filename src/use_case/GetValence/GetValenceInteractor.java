package use_case.GetValence;

public class GetValenceInteractor implements GetValenceInputBoundary{

    final GetValenceDataAccessInterface getValenceDataAccessInterface;

    final GetValenceOutputBoundary getValencePresenter;

    public GetValenceInteractor(GetValenceDataAccessInterface getValenceDataAccessInterface,
                                GetValenceOutputBoundary getValencePresenter) {
        this.getValenceDataAccessInterface = getValenceDataAccessInterface;
        this.getValencePresenter = getValencePresenter;
    }

    public void execute() {

        GetValenceOutputData getValenceOutputData;

    }
}
