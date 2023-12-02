package app;

import data_access.UserDataAccessObject;
import interface_adapter.CompositeViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import view.LoggedInView;
import view.LoginView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

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
        CompositeViewModel compositeViewModel = new CompositeViewModel();

        UserDataAccessObject userDataAccessObject;
        try{
            userDataAccessObject = new UserDataAccessObject();
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        LoginView loginView =  LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject) ;
        assert loginView != null;
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView =  LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel, compositeViewModel);
        assert loggedInView != null;
        views.add(loggedInView, loggedInView.viewname);

        viewManagerModel.setActiveViewName(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
