package interface_adapter.get_valence;

import use_case.get_valence.GetValenceInputBoundary;
import use_case.get_valence.GetValenceInputData;

import java.io.IOException;

public class GetValenceController {

    final GetValenceInputBoundary getValenceInteractor;

    public GetValenceController(GetValenceInputBoundary getValenceInputBoundary) {
        this.getValenceInteractor = getValenceInputBoundary;
    }

    public void execute(String id) throws Exception {
        // executes the interactor on the id and timeframe
        GetValenceState getValenceState = new GetValenceState();
        String timeframe = getValenceState.getTimeframe();
        GetValenceInputData getValenceInputData = new GetValenceInputData(id, timeframe);
        this.getValenceInteractor.execute(getValenceInputData); }


}
