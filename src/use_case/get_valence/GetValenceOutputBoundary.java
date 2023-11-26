package use_case.get_valence;

public interface GetValenceOutputBoundary {

    public void prepareSuccessView(GetValenceOutputData getValenceOutputData);

    void prepareFailView(String error);
}
