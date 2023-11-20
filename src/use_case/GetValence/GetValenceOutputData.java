package use_case.GetValence;

public class GetValenceOutputData {

    private final String valence;

    private final boolean atLeastOneSong;

    GetValenceOutputData(String valence) {

        this.valence = valence;
        atLeastOneSong = !valence.equals("-1");
    }

    public String get_valence() { return this.valence; }

    public boolean get_atLeastOneSong() { return this.atLeastOneSong; }
}
