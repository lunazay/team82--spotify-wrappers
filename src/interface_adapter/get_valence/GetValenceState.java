package interface_adapter.get_valence;

import use_case.GetValence.GetValenceOutputBoundary;

public class GetValenceState {

    private String valence = "";

    public GetValenceState() {}

    public String getValence() { return this.valence; }

    public void setValence(String valence) { this.valence = valence; }

}