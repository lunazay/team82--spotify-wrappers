package interface_adapter.get_valence;

import use_case.GetValence.GetValenceInputBoundary;
import use_case.GetValence.GetValenceInputData;

import java.io.IOException;

public class GetValenceController {

    final GetValenceInputBoundary getValenceInteractor;

    public GetValenceController(GetValenceInputBoundary getValenceInputBoundary) {
        this.getValenceInteractor = getValenceInputBoundary;
    }

    void execute(String id, String timeframe) throws IOException {

        // executes the interactor on the id and timeframe
        GetValenceInputData getValenceInputData = new GetValenceInputData(id, timeframe);
        this.getValenceInteractor.execute(getValenceInputData); }


}
