package app;

import data_access.UserDataAccessObject;
import interface_adapter.CompositeViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_valence.GetValenceController;
import interface_adapter.get_valence.GetValencePresenter;
import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.related_artists.RelatedArtistsPresenter;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_album.TopAlbumController;
import interface_adapter.top_album.TopAlbumPresenter;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_artists.TopArtistsPresenter;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenrePresenter;
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
import use_case.related_artists.RelatedArtistsDataAccessInterface;
import use_case.related_artists.RelatedArtistsInputBoundary;
import use_case.related_artists.RelatedArtistsInteractor;
import use_case.related_artists.RelatedArtistsOutputBoundary;
import use_case.top_album.*;
import use_case.top_artists.TopArtistsDataAccessInterface;
import use_case.top_artists.TopArtistsInputBoundary;
import use_case.top_artists.TopArtistsInteractor;
import use_case.top_artists.TopArtistsOutputBoundary;
import use_case.top_genre.TopGenreDataAccessInterface;
import use_case.top_genre.TopGenreInputBoundary;
import use_case.top_genre.TopGenreInteractor;
import use_case.top_genre.TopGenreOutputBoundary;
import use_case.top_songs.TopSongsDataAccessInterface;
import use_case.top_songs.TopSongsInputBoundary;
import use_case.top_songs.TopSongsInteractor;
import use_case.top_songs.TopSongsOutputBoundary;
import view.LoggedInView;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class LoggedInUseCaseFactory {

    private LoggedInUseCaseFactory() {}

    public static LoggedInView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            CompositeViewModel compositeViewModel) {

            try {
                TopGenreController topGenreController = createTopGenreController(viewManagerModel, compositeViewModel);
                TopAlbumController topAlbumController = createTopAlbumUseCase(viewManagerModel, compositeViewModel);
                TopSongsController topSongsController = createTopSongsUseCase(viewManagerModel, compositeViewModel);
                TopArtistsController topArtistsController = createTopArtistsUseCase(viewManagerModel);
                GetValenceController getValenceController = createGetValenceUseCase(viewManagerModel, compositeViewModel);
                RelatedArtistsController relatedArtistsController = createRelatedArtistsUseCase(viewManagerModel);


                return new LoggedInView(loggedInViewModel, topGenreController, topAlbumController, topSongsController,
                        topArtistsController,getValenceController,relatedArtistsController, compositeViewModel);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open user data file.");
            }

            return null;

    }

    private static GetValenceController createGetValenceUseCase(ViewManagerModel viewManagerModel,
                                                                CompositeViewModel compositeViewModel) throws IOException {
        GetValenceDataAccessInterface getValenceDataAccessInterface = new UserDataAccessObject();
        GetValenceViewModel getValenceViewModel = new GetValenceViewModel();
        getValenceViewModel.addPropertyChangeListener((PropertyChangeListener) compositeViewModel);
        GetValenceOutputBoundary getValenceOutputBoundary = new GetValencePresenter(getValenceViewModel, viewManagerModel);

        GetValenceInputBoundary getValenceInteractor = new GetValenceInteractor(
                getValenceDataAccessInterface, getValenceOutputBoundary);

        return new GetValenceController(getValenceInteractor);
    }

    private static TopSongsController createTopSongsUseCase(ViewManagerModel viewManagerModel, CompositeViewModel compositeViewModel) throws IOException {

        TopSongsDataAccessInterface topSongsDataAccessInterface = new UserDataAccessObject();
        TopSongsViewModel topSongsViewModel = new TopSongsViewModel();
        topSongsViewModel.addPropertyChangeListener((PropertyChangeListener) compositeViewModel);
        TopSongsOutputBoundary topSongsOutputBoundary = new TopSongsPresenter(viewManagerModel, topSongsViewModel);

        TopSongsInputBoundary topSongsInteractor = new TopSongsInteractor(
                topSongsDataAccessInterface, topSongsOutputBoundary);

        return new TopSongsController(topSongsInteractor);
    }

    private static TopAlbumController createTopAlbumUseCase(ViewManagerModel viewManagerModel,
                                                            CompositeViewModel compositeViewModel) throws IOException {

        TopAlbumDataAccessInterface topAlbumDataAccessInterface = new UserDataAccessObject();
        TopAlbumViewModel topAlbumViewModel = new TopAlbumViewModel();
        topAlbumViewModel.addPropertyChangeListener((PropertyChangeListener) compositeViewModel);
        TopAlbumOutputBoundary topAlbumOutputBoundary = new TopAlbumPresenter(viewManagerModel, topAlbumViewModel);

        TopAlbumInputBoundary topAlbumInteractor = new TopAlbumInteractor(
                topAlbumDataAccessInterface, topAlbumOutputBoundary);

        return new TopAlbumController(topAlbumInteractor);
    }

    private static TopGenreController createTopGenreController(ViewManagerModel viewManagerModel,
                                                               CompositeViewModel compositeViewModel) throws IOException {

        TopGenreDataAccessInterface topGenreDataAccessInterface = new UserDataAccessObject();
        TopGenreViewModel topGenreViewModel = new TopGenreViewModel();
        topGenreViewModel.addPropertyChangeListener((PropertyChangeListener) compositeViewModel);
        TopGenreOutputBoundary topGenreOutputData = new TopGenrePresenter(topGenreViewModel, viewManagerModel);

        TopGenreInputBoundary userGenreInteractor = new TopGenreInteractor(
                topGenreDataAccessInterface, topGenreOutputData);

        return new TopGenreController(userGenreInteractor);
    }

    private static TopArtistsController createTopArtistsUseCase(ViewManagerModel viewManagerModel) throws IOException {

        TopArtistsDataAccessInterface topArtistsDataAccessInterface = new UserDataAccessObject();
        TopArtistsViewModel topArtistsViewModel = new TopArtistsViewModel();
        TopArtistsOutputBoundary topArtistsOutputBoundary = new TopArtistsPresenter(viewManagerModel, topArtistsViewModel);

        TopArtistsInputBoundary userArtistInteractor = new TopArtistsInteractor(topArtistsDataAccessInterface, topArtistsOutputBoundary);

        return new TopArtistsController(userArtistInteractor);
    }

    private static RelatedArtistsController createRelatedArtistsUseCase(ViewManagerModel viewManagerModel) throws IOException {

        RelatedArtistsDataAccessInterface relatedArtistsDataAccessInterface = new UserDataAccessObject();
        RelatedArtistsViewModel relatedArtistsViewModel = new RelatedArtistsViewModel();
        RelatedArtistsOutputBoundary relatedArtistsOutputBoundary = new RelatedArtistsPresenter(viewManagerModel, relatedArtistsViewModel);

        RelatedArtistsInputBoundary userArtistInteractor = new RelatedArtistsInteractor(relatedArtistsDataAccessInterface, relatedArtistsOutputBoundary);

        return new RelatedArtistsController(userArtistInteractor);
    }



}
