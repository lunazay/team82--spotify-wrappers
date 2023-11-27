package use_case.top_songs;
import java.util.ArrayList;
import java.util.List;

public class TopSongsOutputData {

    private final List<String> songNames;

    private Integer songNumber;

    private boolean useCaseFailed;

    public TopSongsOutputData(List<String> songNames, boolean useCaseFailed, Integer songNumber) {
        this.songNames = songNames;
        this.useCaseFailed = useCaseFailed;
        this.songNumber = songNumber;

    }

    public ArrayList<String> getSongNames() {
        return (ArrayList<String>) songNames;
    }
}

