package use_case.TopSongs;
import java.util.List;

public class TopSongsOutputData {

    private List<String> songNames;

    private boolean useCaseFailed;

    public TopSongsOutputData(List<String> songNames, boolean useCaseFailed) {
        this.songNames = songNames;
        this.useCaseFailed = useCaseFailed;

    }

    public List<String> getsongNames() {
        return songNames;
    }
}

