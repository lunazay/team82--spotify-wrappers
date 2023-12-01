package interface_adapter;

import app.LoggedInUseCaseFactory;
import interface_adapter.get_valence.GetValenceController;
import interface_adapter.get_valence.GetValenceState;
import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.related_artists.RelatedArtistsState;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_album.TopAlbumController;
import interface_adapter.top_album.TopAlbumState;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_artists.TopArtistsState;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenreState;
import interface_adapter.top_genre.TopGenreViewModel;
import interface_adapter.top_songs.TopSongsController;
import interface_adapter.top_songs.TopSongsState;
import interface_adapter.top_songs.TopSongsViewModel;
import use_case.top_songs.TopSongsInputBoundary;
import view.LoggedInView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class CompositeViewModel extends JPanel implements PropertyChangeListener{
    private GetValenceViewModel getValenceViewModel;
    private RelatedArtistsViewModel relatedArtistsViewModel;
    public TopGenreViewModel topGenreViewModel;
    private TopSongsViewModel topSongsViewModel;
    private TopAlbumViewModel topAlbumViewModel;
    private TopArtistsViewModel topArtistsViewModel;

    public JPanel gridPanel;

    public CompositeViewModel() {
        setLayout(new GridLayout(3, 2)); // Adjust layout as needed;

        this.relatedArtistsViewModel = new RelatedArtistsViewModel();
        this.topGenreViewModel = new TopGenreViewModel();
        this.topSongsViewModel = new TopSongsViewModel();
        this.topAlbumViewModel = new TopAlbumViewModel();
        this.topArtistsViewModel = new TopArtistsViewModel();
        this.getValenceViewModel = new GetValenceViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

        // Create Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String actionCommand = evt.getActionCommand();
                System.out.println(("Click" + evt.getActionCommand()));
                Container parent = getParent();
                JPanel selectedView = null;
                // Get the parent container (assuming LoggedInView)
                ViewManagerModel viewManagerModel = new ViewManagerModel();
                LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel, CompositeViewModel.this);
                if (loggedInView != null) {
                    selectedView = loggedInView;
                    showLoggedInView(loggedInView); // Show LoggedInView again
                }
            }

            public void showLoggedInView(JPanel loggedInView) {
                // Clear the existing content of the LoggedInView and show the selected use case view
                // Here's what the showUseCaseView method does:
                //
                //It Clears Existing Content: Before displaying a new view, it removes any existing components from the LoggedInView. This ensures that only one view is visible at a time.
                //
                //It Adds the Selected Use Case View: It adds the specified use case view (useCase1View, useCase2View, or useCase3View) to the LoggedInView.
                //
                //It Refreshes the UI: After updating the contents, it calls revalidate() to inform Swing to re-layout the components and repaint() to refresh the UI, ensuring that the changes made are reflected visually.
                removeAll();
                add(loggedInView);
                revalidate();
                repaint();
            }
        });
        // Use a separate JPanel for grid layout to organize view models
        gridPanel = new JPanel(new GridLayout(3, 2)); // Adjust layout as needed

        // Add view panels to the gridPanel
        gridPanel.add(getValenceViewModel.getViewPanel());
        gridPanel.add(relatedArtistsViewModel.getViewPanel());
        gridPanel.add(topGenreViewModel.getViewPanel());
        gridPanel.add(topSongsViewModel.getViewPanel());
        gridPanel.add(topAlbumViewModel.getViewPanel());
        gridPanel.add(topArtistsViewModel.getViewPanel());

        add(backButton, BorderLayout.SOUTH); // Add the Back button at the top
        add(gridPanel, BorderLayout.CENTER); // Add the gridPanel to hold view models


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("TopGenreState")) {
            TopGenreState currentState = (TopGenreState) evt.getNewValue();
            ArrayList<String> genres = currentState.getGenres();
            this.topGenreViewModel.setgenres(genres);
        }
        if (evt.getPropertyName().equals("TopAlbumState")) {
            TopAlbumState currentState = (TopAlbumState) evt.getNewValue();
            // List<String> albums = currentState.getTopAlbumNames();
            this.topAlbumViewModel.setState(currentState);
        }
        if (evt.getPropertyName().equals("TopSongsState")) {
            TopSongsState currentState = (TopSongsState) evt.getNewValue();
            this.topSongsViewModel.setState(currentState);
        }
        if (evt.getPropertyName().equals("TopArtistsState")) {
            TopArtistsState currentState = (TopArtistsState) evt.getNewValue();
            this.topArtistsViewModel.setState(currentState);
        }
        if (evt.getPropertyName().equals("ValenceState")) {
            GetValenceState getValenceState = (GetValenceState) evt.getNewValue();
            this.getValenceViewModel.setState(getValenceState);
        }
        if (evt.getPropertyName().equals("RelatedArtistsState")) {
            RelatedArtistsState relatedArtistsState = (RelatedArtistsState) evt.getNewValue();
            this.relatedArtistsViewModel.setState(relatedArtistsState);
        }
    }

    public JPanel getGridPanel() {
        gridPanel = new JPanel(new GridLayout(3, 2)); // Adjust layout as needed

        // Add view panels to the gridPanel
        gridPanel.add(getValenceViewModel.getViewPanel());
        gridPanel.add(relatedArtistsViewModel.getViewPanel());
        gridPanel.add(topGenreViewModel.getViewPanel());
        gridPanel.add(topSongsViewModel.getViewPanel());
        gridPanel.add(topAlbumViewModel.getViewPanel());
        gridPanel.add(topArtistsViewModel.getViewPanel());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String actionCommand = evt.getActionCommand();
                System.out.println(("Click" + evt.getActionCommand()));
                Container parent = getParent();
                JPanel selectedView = null;
                // Get the parent container (assuming LoggedInView)
                ViewManagerModel viewManagerModel = new ViewManagerModel();
                LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
                LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel, CompositeViewModel.this);
                if (loggedInView != null) {
                    selectedView = loggedInView;
                    showLoggedInView(loggedInView); // Show LoggedInView again
                }
            }

            public void showLoggedInView(JPanel loggedInView) {
                // Clear the existing content of the LoggedInView and show the selected use case view
                // Here's what the showUseCaseView method does:
                //
                //It Clears Existing Content: Before displaying a new view, it removes any existing components from the LoggedInView. This ensures that only one view is visible at a time.
                //
                //It Adds the Selected Use Case View: It adds the specified use case view (useCase1View, useCase2View, or useCase3View) to the LoggedInView.
                //
                //It Refreshes the UI: After updating the contents, it calls revalidate() to inform Swing to re-layout the components and repaint() to refresh the UI, ensuring that the changes made are reflected visually.
                removeAll();
                add(loggedInView);
                revalidate();
                repaint();
            }
        });

        gridPanel.add(backButton, BorderLayout.SOUTH); // Add the Back button at the top
        add(gridPanel, BorderLayout.CENTER); // Add the gridPanel to hold view models

        return gridPanel;
    }
}