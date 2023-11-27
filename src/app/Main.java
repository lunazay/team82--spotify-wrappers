package app;

import api.SpotDevelopDB;
import api.DevelopDB;

import data_access.UserDataAccessObject;
import entity.User;
import entity.Artist;
import entity.Song;
import entity.Genre;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreViewModel;
import interface_adapter.top_songs.TopSongsViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
import use_case.login.LoginUserDataAccessInterface;
import view.LoggedInView;
import view.LoginView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class Main {
    public static void main(String[] args){
        JFrame application = new JFrame("Output Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        GetValenceViewModel getValenceViewModel = new GetValenceViewModel();
        RelatedArtistsViewModel relatedArtistsViewModel = new RelatedArtistsViewModel();
        TopSongsViewModel topSongsViewModel = new TopSongsViewModel();
        TopAlbumViewModel topAlbumViewModel = new TopAlbumViewModel();
        TopArtistsViewModel topArtistsViewModel = new TopArtistsViewModel();
        TopGenreViewModel topGenreViewModel = new TopGenreViewModel();

        UserDataAccessObject userDataAccessObject;
        try{
            userDataAccessObject = new UserDataAccessObject();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        // i think we need to do this for every view?
        LoginView loginView =  LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject) ;
        views.add(loginView, loginView.viewname);

        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        views.add(loggedInView, loggedInView.viewName());

        viewManagerModel.setActiveViewName(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
