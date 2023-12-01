package interface_adapter.logged_in;

import interface_adapter.top_genre.TopGenreState;

public class LoggedInState {
    public LoggedInState(){}
    private String userId;
    private TopGenreState topGenreState;

    public void setTopGenreState(TopGenreState state) {
        this.topGenreState = state;
    }

    public TopGenreState getTopGenreState() {
        return topGenreState;
    }

    public void setId(String userId) {
        this.userId = userId;
    }

    public String getid() {
        return userId;
    }
}
