package interface_adapter.get_valence;

import use_case.GetValence.GetValenceInputBoundary;

public class GetValenceController {

    final GetValenceInputBoundary getValenceInteractor;

    public GetValenceController(GetValenceInputBoundary getValenceInputBoundary) {
        this.getValenceInteractor = getValenceInputBoundary;
    }

    void execute() { this.getValenceInteractor.execute(); }


}
