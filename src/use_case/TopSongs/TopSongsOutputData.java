package use_case.TopSongs;
import java.util.List;

public class TopSongsOutputData {

    private final String id;
    private List<String> songNames;

    private boolean useCaseFailed;

    public TopSongsOutputData(String id, List<String> songNames, boolean useCaseFailed) {
        this.id = id;
        this.songNames = songNames;
        this.useCaseFailed = useCaseFailed;

    }

    public String getId() {
        return id;
    }

    public List<String> getsongNames() {
        return songNames;
    }
}

