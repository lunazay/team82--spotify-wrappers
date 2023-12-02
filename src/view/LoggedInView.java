package view;

import app.LoggedInUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_valence.GetValenceController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.CompositeViewModel;
import interface_adapter.related_artists.RelatedArtistsController;
import interface_adapter.top_album.TopAlbumController;
import interface_adapter.top_artists.TopArtistsController;
import interface_adapter.top_genre.TopGenreController;
import interface_adapter.top_genre.TopGenreState;
import interface_adapter.top_songs.TopSongsController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {
        public final String viewName = "logged in";
        private final LoggedInViewModel loggedInViewModel;
        private final CompositeViewModel compositeView;

        private final TopGenreController topGenreController;
        private final TopAlbumController topAlbumController;
        private final TopSongsController topSongsController;
        private final TopArtistsController topArtistsController;
        private final GetValenceController getValenceController;
        private final RelatedArtistsController relatedArtistsController;

        final JButton shortTerm;
        final JButton mediumTerm;
        final JButton longTerm;
        final JButton done;

    /**
     * Constructs a view window with a title and 3 JButtons for each timeframe.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel, TopGenreController topGenreController,
                        TopAlbumController topAlbumController, TopSongsController topSongsController,
                        TopArtistsController topArtistsController, GetValenceController getValenceController,
                        RelatedArtistsController relatedArtistsController, CompositeViewModel compositeView){
        this.loggedInViewModel = loggedInViewModel;
        this.topGenreController = topGenreController;
        this.topAlbumController = topAlbumController;
        this.topSongsController = topSongsController;
        this.topArtistsController = topArtistsController;
        this.getValenceController = getValenceController;
        this.relatedArtistsController = relatedArtistsController;
        this.loggedInViewModel.addPropertyChangeListener(this);
        this.compositeView = compositeView;

        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        shortTerm = new JButton(LoggedInViewModel.SHORT_BUTTON_LABEL);
        buttons.add(shortTerm);

        mediumTerm = new JButton(LoggedInViewModel.MEDIUM_BUTTON_LABEL);
        buttons.add(mediumTerm);

        longTerm = new JButton(LoggedInViewModel.LONG_BUTTON_LABEL);
        buttons.add(longTerm);

        done = new JButton(LoggedInViewModel.DONE_BUTTON_LABEL);
        buttons.add(done);

        shortTerm.addActionListener(this);
        mediumTerm.addActionListener(this);
        longTerm.addActionListener(this);
        done.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String actionCommand = evt.getActionCommand();
        System.out.println("Click " + evt.getActionCommand());

        if (actionCommand.equals(LoggedInViewModel.SHORT_BUTTON_LABEL)){
            LoggedInState currentState = loggedInViewModel.getState();
            topGenreController.execute("short_term", currentState.getid());
            topArtistsController.execute("short_term", currentState.getid());
            topAlbumController.execute("short_term", currentState.getid());
            topSongsController.execute("short_term", currentState.getid());
            try {
                getValenceController.execute("short_term", currentState.getid());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                relatedArtistsController.execute("short_term", currentState.getid());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            JPanel selectedView = compositeView.getGridPanel();
            addBackButton(selectedView);
            showUseCaseView(selectedView);
        }
        if (actionCommand.equals(LoggedInViewModel.MEDIUM_BUTTON_LABEL)){
            LoggedInState currentState = loggedInViewModel.getState();
            topGenreController.execute("medium_term", currentState.getid());
            topArtistsController.execute("medium_term",currentState.getid());
            topAlbumController.execute("medium_term", currentState.getid());
            topSongsController.execute("medium_term", currentState.getid());
            try {
                getValenceController.execute("medium_term", currentState.getid());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                relatedArtistsController.execute("medium_term", currentState.getid());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            JPanel selectedView = compositeView.getGridPanel();
            addBackButton(selectedView);
            showUseCaseView(selectedView);
        }
        if (actionCommand.equals(LoggedInViewModel.LONG_BUTTON_LABEL)){
            LoggedInState currentState = loggedInViewModel.getState();
            topGenreController.execute("long_term", currentState.getid());
            topArtistsController.execute("long_term", currentState.getid());
            topAlbumController.execute("long_term", currentState.getid());
            topSongsController.execute("long_term", currentState.getid());
            try {
                getValenceController.execute("long_term", currentState.getid());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                relatedArtistsController.execute("long_term", currentState.getid());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            JPanel selectedView = compositeView.getGridPanel();
            addBackButton(selectedView);
            showUseCaseView(selectedView);
        } else if (actionCommand.equals(LoggedInViewModel.DONE_BUTTON_LABEL)) {
            // Action for the "Done" button
            int confirmExit = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?");
            if (confirmExit == JOptionPane.YES_OPTION) {
                // Perform necessary cleanup and exit the application
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                frame.dispose(); // Close the JFrame
                System.exit(0); // Terminate the application
            }
        }
    }

    /**
     * Clears the existing content of the LoggedInView and shows the selected use case view.
     * @param useCaseView the specified use case view to display
     */
    public void showUseCaseView(JPanel useCaseView) {
        // Clears Existing Content: Before displaying a new view, it removes any existing components from the LoggedInView.
        // This ensures that only one view is visible at a time.
        removeAll();
        // Adds the Selected Use Case View: It adds the specified use case view to the LoggedInView.
        add(useCaseView);
        // Refreshes the UI: After updating the contents, it calls revalidate() to inform Swing to re-layout the components
        // and repaint() to refresh the UI, ensuring that the changes made are reflected visually.
        revalidate();
        repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // LoggedInState state = (LoggedInState) evt.getNewValue();
        if (evt.getPropertyName().equals("TopGenreState")) {
            TopGenreState state = (TopGenreState) evt.getNewValue();
            LoggedInState loggedInState = loggedInViewModel.getState();
            loggedInState.setTopGenreState(state);
            loggedInViewModel.setState(loggedInState);
        }

    }

    /**
     * Adds a back button within each state (short term, medium term, long term) of the program. This allows
     * the user to navigate back to the main menu and select a different timeframe.
     * @param panel the panel to add the button to.
     */
    public void addBackButton(JPanel panel) {
        JButton backButton = new JButton("Back");
        backButton.addActionListener(evt -> {
            System.out.println(("Click " + evt.getActionCommand()));
            // Get the parent container (assuming LoggedInView)
            ViewManagerModel viewManagerModel = new ViewManagerModel();
            LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
            CompositeViewModel compositeViewModel = new CompositeViewModel();
            LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel, compositeViewModel);
            if (loggedInView != null) {
                showUseCaseView(loggedInView); // Show LoggedInView again
            }
        });
        panel.add(backButton);
    }

}

