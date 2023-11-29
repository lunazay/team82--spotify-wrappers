package app;

import data_access.UserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.related_artists.RelatedArtistsPresenter;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_artists.TopArtistsPresenter;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenrePresenter;
import interface_adapter.top_genre.TopGenreViewModel;
import use_case.related_artists.RelatedArtistsDataAccessInterface;
import use_case.related_artists.RelatedArtistsInputBoundary;
import use_case.related_artists.RelatedArtistsInteractor;
import use_case.related_artists.RelatedArtistsOutputBoundary;
import use_case.top_artists.TopArtistsDataAccessInterface;
import use_case.top_artists.TopArtistsInputBoundary;
import use_case.top_artists.TopArtistsInteractor;
import use_case.top_artists.TopArtistsOutputBoundary;
import use_case.top_genre.*;
import view.LoggedInView;

public class LoggedInFactory {
    private LoggedInFactory() {}

    public static LoggedInView create(
            ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, UserDataAccessObject userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            ClearController clearController = createUserClearUseCase(viewManagerModel, clearViewModel, clearDataAccessObject);
            return new SignupView(signupController, signupViewModel, clearController, clearDataAccessObject, clearViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static TopGenreController createGenreUseCase(ViewManagerModel viewManagerModel, TopGenreViewModel topGenreViewModel, TopGenreDataAccessInterface topGenreDataAccessInterface) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        TopGenreOutputBoundary topGenreOutputData = new TopGenrePresenter(topGenreViewModel, viewManagerModel);

        TopGenreInputBoundary userGenreInteractor = new TopGenreInteractor(
                topGenreDataAccessInterface, topGenreOutputData);

        return new TopGenreController(userGenreInteractor);
    }

    private static TopArtistsController createArtistUseCase(ViewManagerModel viewManagerModel, TopArtistsViewModel topArtistsViewModel, TopArtistsDataAccessInterface topArtistsDataAccessInterface) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        TopArtistsOutputBoundary topArtistsOutputBoundary = new TopArtistsPresenter(viewManagerModel, topArtistsViewModel);

        TopArtistsInputBoundary userArtistInteractor = new TopArtistsInteractor(topArtistsDataAccessInterface, topArtistsOutputBoundary);

        return new TopArtistsController(userArtistInteractor);
    }

    private static RelatedArtistsController createGetArtistUseCase(ViewManagerModel viewManagerModel, RelatedArtistsViewModel relatedArtistsViewModel, RelatedArtistsDataAccessInterface relatedArtistsDataAccessInterface) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        RelatedArtistsOutputBoundary relatedArtistsOutputBoundary = new RelatedArtistsPresenter(viewManagerModel, relatedArtistsViewModel);

        RelatedArtistsInputBoundary userArtistInteractor = new RelatedArtistsInteractor(relatedArtistsDataAccessInterface, relatedArtistsOutputBoundary);

        return new RelatedArtistsController(userArtistInteractor);
}
