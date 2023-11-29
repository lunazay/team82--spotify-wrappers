package app;

import data_access.UserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_valence.GetValenceController;
import interface_adapter.get_valence.GetValencePresenter;
import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.top_album.TopAlbumController;
import interface_adapter.top_album.TopAlbumPresenter;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenreViewModel;
import interface_adapter.top_songs.TopSongsController;
import interface_adapter.top_songs.TopSongsPresenter;
import interface_adapter.top_songs.TopSongsState;
import interface_adapter.top_songs.TopSongsViewModel;
import use_case.get_valence.GetValenceDataAccessInterface;
import use_case.get_valence.GetValenceInputBoundary;
import use_case.get_valence.GetValenceInteractor;
import use_case.get_valence.GetValenceOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import use_case.top_album.*;
import use_case.top_genre.TopGenreDataAccessInterface;
import use_case.top_songs.TopSongsDataAccessInterface;
import use_case.top_songs.TopSongsInputBoundary;
import use_case.top_songs.TopSongsInteractor;
import use_case.top_songs.TopSongsOutputBoundary;
import view.LoggedInView;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

public class LoggedInUseCaseFactory {

    private LoggedInUseCaseFactory() {}

    public static LoggedInView create(
        ViewManagerModel viewManagerModel,
        LoggedInViewModel loggedInViewModel) {

            try {
                TopGenreController topGenreController = createTopGenreController(viewManagerModel);
                TopAlbumController topAlbumController = createTopAlbumUseCase(viewManagerModel);
                TopSongsController topSongsController = createTopSongsUseCase(viewManagerModel);
                TopArtistsController topArtistsController = createTopArtistsUseCase(viewManagerModel);
                GetValenceController getValenceController = createGetValenceUseCase(viewManagerModel);
                RelatedArtistsController relatedArtistsController = createRelatedArtistsUseCase(viewManagerModel);


                return new LoggedInView(loggedInViewModel, topGenreController, topAlbumController, topSongsController,
                        topArtistsController,getValenceController,relatedArtistsController);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open user data file.");
            }

            return null;

            // TODO: do this last; once we have all the Gets for al the use cases.
    }

    private static GetValenceController createGetValenceUseCase(ViewManagerModel viewManagerModel) throws IOException {
        GetValenceDataAccessInterface getValenceDataAccessInterface = new UserDataAccessObject();
        GetValenceViewModel getValenceViewModel = new GetValenceViewModel();
        GetValenceOutputBoundary getValenceOutputBoundary = new GetValencePresenter(getValenceViewModel, viewManagerModel);

        GetValenceInputBoundary getValenceInteractor = new GetValenceInteractor(
                getValenceDataAccessInterface, getValenceOutputBoundary);

        return new GetValenceController(getValenceInteractor);
    }

    private static TopSongsController createTopSongsUseCase(ViewManagerModel viewManagerModel) throws IOException {

        TopSongsDataAccessInterface topSongsDataAccessInterface = new UserDataAccessObject();
        TopSongsViewModel topSongsViewModel = new TopSongsViewModel();
        TopSongsOutputBoundary topSongsOutputBoundary = new TopSongsPresenter(viewManagerModel, topSongsViewModel);

        TopSongsInputBoundary topSongsInteractor = new TopSongsInteractor(
                topSongsDataAccessInterface, topSongsOutputBoundary);

        return new TopSongsController(topSongsInteractor);
    }

    private static TopAlbumController createTopAlbumUseCase(ViewManagerModel viewManagerModel) throws IOException {

        TopAlbumDataAccessInterface topAlbumDataAccessInterface = new UserDataAccessObject();
        TopAlbumViewModel topAlbumViewModel = new TopAlbumViewModel();
        TopAlbumOutputBoundary topAlbumOutputBoundary = new TopAlbumPresenter(viewManagerModel, topAlbumViewModel);

        TopAlbumInputBoundary topAlbumInteractor = new TopAlbumInteractor(
                topAlbumDataAccessInterface, topAlbumOutputBoundary);

        return new TopAlbumController(topAlbumInteractor);
    }


}
