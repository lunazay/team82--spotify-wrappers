package interface_adapter;

import interface_adapter.get_valence.GetValenceController;
import interface_adapter.get_valence.GetValenceViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.related_artists.RelatedArtistsViewModel;
import interface_adapter.top_album.TopAlbumController;
import interface_adapter.top_album.TopAlbumViewModel;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenreViewModel;
import interface_adapter.top_songs.TopSongsController;
import interface_adapter.top_songs.TopSongsViewModel;
import use_case.top_songs.TopSongsInputBoundary;
import view.LoggedInView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompositeViewModel extends JPanel{
    private GetValenceViewModel getValenceViewModel;
    private RelatedArtistsViewModel relatedArtistsViewModel;
    private TopGenreViewModel topGenreViewModel;
    private TopSongsViewModel topSongsViewModel;
    private TopAlbumViewModel topAlbumViewModel;
    private TopArtistsViewModel topArtistsViewModel;
    private TopGenreController topGenreController;


    public CompositeViewModel(){
        setLayout(new GridLayout(3, 2)); // Adjust layout as needed
        RelatedArtistsViewModel relatedArtistsViewModel = new RelatedArtistsViewModel();
        TopGenreViewModel topGenreViewModel = new TopGenreViewModel();
        TopSongsViewModel topSongsViewModel = new TopSongsViewModel();
        TopAlbumViewModel topAlbumViewModel = new TopAlbumViewModel();
        TopArtistsViewModel topArtistsViewModel = new TopArtistsViewModel();
        GetValenceViewModel getValenceViewModel = new GetValenceViewModel();
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
                LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
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
        JPanel gridPanel = new JPanel(new GridLayout(3, 2)); // Adjust layout as needed

        // Add view panels to the gridPanel
        gridPanel.add(getValenceViewModel.getViewPanel());
        gridPanel.add(relatedArtistsViewModel.getViewPanel());
        gridPanel.add(topGenreViewModel.getViewPanel());
        gridPanel.add(topSongsViewModel.getViewPanel());
        gridPanel.add(topAlbumViewModel.getViewPanel());
        // gridPanel.add(topArtistsViewModel.getViewPanel());

        add(backButton, BorderLayout.SOUTH); // Add the Back button at the top
        add(gridPanel, BorderLayout.CENTER); // Add the gridPanel to hold view models


    }

}
