package interface_adapter.get_valence;

import interface_adapter.ViewManagerModel;

public class GetValenceViewModel extends ViewManagerModel {

    private GetValenceState state = new GetValenceState();

    public void setState(GetValenceState state) { this.state = state; }

    public GetValenceState getState() { return this.state; }

}
