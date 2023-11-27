package interface_adapter.get_valence;

import interface_adapter.ViewManagerModel;
import use_case.get_valence.GetValenceOutputBoundary;
import use_case.get_valence.GetValenceOutputData;

public class GetValencePresenter implements GetValenceOutputBoundary {

    private final GetValenceViewModel getValenceViewModel;

    private ViewManagerModel viewManagerModel;

    public GetValencePresenter(GetValenceViewModel getValenceViewModel, ViewManagerModel viewManagerModel) {
        this.getValenceViewModel = getValenceViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(GetValenceOutputData getValenceOutputData) {

        GetValenceState getValenceState = getValenceViewModel.getState();

        getValenceState.setValence(getValenceOutputData.get_valence());

        this.getValenceViewModel.setState(getValenceState);
        this.getValenceViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        GetValenceState getValenceState = getValenceViewModel.getState();
        getValenceState.setError("Listen to some music bro!");
        getValenceViewModel.firePropertyChanged();
    }
}
