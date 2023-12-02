package interface_adapter.get_valence;

import use_case.get_valence.GetValenceInputBoundary;
import use_case.get_valence.GetValenceInputData;


public class GetValenceController {

    final GetValenceInputBoundary getValenceInteractor;

    public GetValenceController(GetValenceInputBoundary getValenceInputBoundary) {
        this.getValenceInteractor = getValenceInputBoundary;
    }

    public void execute(String timeframe, String id) throws Exception {
        // executes the interactor on the id and timeframe
        GetValenceInputData getValenceInputData = new GetValenceInputData(id, timeframe);
        this.getValenceInteractor.execute(getValenceInputData); }


}
