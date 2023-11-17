package use_case.TopSongs;
import java.util.List;

public class TopSongsOutputData {

    private List<String> songNames;

    private Integer songNumber;

    private boolean useCaseFailed;

    public TopSongsOutputData(List<String> songNames, boolean useCaseFailed, Integer songNumber) {
        this.songNames = songNames;
        this.useCaseFailed = useCaseFailed;
        this.songNumber = songNumber;

    }

    public List<String> getSongNames() {
        return songNames;
    }
}

