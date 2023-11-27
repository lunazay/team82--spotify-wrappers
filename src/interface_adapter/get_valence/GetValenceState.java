package interface_adapter.get_valence;

public class GetValenceState {

    private String valence = ""; // default value of valence is just an empty string

    private String error = null;

    public GetValenceState() {}


    public String getValence() { return this.valence; }

    public void setValence(String valence) { this.valence = valence;}

    public void setError(String error) {
        this.error = error;
    }
}