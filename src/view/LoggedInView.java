package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.CompositeViewModel;
import interface_adapter.top_genre.TopGenreViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {
        public final String viewName = "logged in";
        private final LoggedInViewModel loggedInViewModel;
        private final CompositeViewModel compositeView;
        final JButton shortTerm;
        final JButton mediumTerm;
        final JButton longTerm;
        final JButton done;

    /**
     * A window with a title and 3 JButtons.
     * @param loggedInViewModel
     */

    public LoggedInView(LoggedInViewModel loggedInViewModel){

            this.loggedInViewModel = loggedInViewModel;
            this.loggedInViewModel.addPropertyChangeListener(this);
            compositeView = new CompositeViewModel();

            JLabel title = new JLabel("Logged In Screen");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel buttons = new JPanel();
            shortTerm = new JButton(loggedInViewModel.SHORT_BUTTON_LABEL);
            buttons.add(shortTerm);

            mediumTerm = new JButton(loggedInViewModel.MEDIUM_BUTTON_LABEL);
            buttons.add(mediumTerm);

            longTerm = new JButton(loggedInViewModel.LONG_BUTTON_LABEL);
            buttons.add(longTerm);

            done = new JButton(loggedInViewModel.DONE_BUTTON_LABEL);
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
        if (actionCommand.equals(loggedInViewModel.SHORT_BUTTON_LABEL) ||
                actionCommand.equals(loggedInViewModel.MEDIUM_BUTTON_LABEL) ||
                actionCommand.equals(loggedInViewModel.LONG_BUTTON_LABEL)) {
            JPanel selectedView = compositeView;
            if (selectedView != null) {
                showUseCaseView(selectedView);
            }
        } else if (actionCommand.equals(loggedInViewModel.DONE_BUTTON_LABEL)) {
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

    public void showUseCaseView(JPanel useCaseView) {
        // Clear the existing content of the LoggedInView and show the selected use case view
        // Here's what the showUseCaseView method does:
        //
        //It Clears Existing Content: Before displaying a new view, it removes any existing components from the LoggedInView. This ensures that only one view is visible at a time.
        //
        //It Adds the Selected Use Case View: It adds the specified use case view (useCase1View, useCase2View, or useCase3View) to the LoggedInView.
        //
        //It Refreshes the UI: After updating the contents, it calls revalidate() to inform Swing to re-layout the components and repaint() to refresh the UI, ensuring that the changes made are reflected visually.
        removeAll();
        add(useCaseView);
        revalidate();
        repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();

    }

    public String viewName() {
        return viewName;
    }
}

