package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.LoggedInState;
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
        final JButton shortTerm;
        final JButton mediumTerm;
        final JButton longTerm;

    /**
     * A window with a title and 3 JButtons.
     * @param loggedInViewModel
     */

    public LoggedInView(LoggedInViewModel loggedInViewModel){

            this.loggedInViewModel = loggedInViewModel;
            this.loggedInViewModel.addPropertyChangeListener(this);

            JLabel title = new JLabel("Logged In Screen");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel buttons = new JPanel();
            shortTerm = new JButton(loggedInViewModel.SHORT_BUTTON_LABEL);
            buttons.add(shortTerm);

            mediumTerm = new JButton(loggedInViewModel.MEDIUM_BUTTON_LABEL);
            buttons.add(mediumTerm);

            longTerm = new JButton(loggedInViewModel.LONG_BUTTON_LABEL);
            buttons.add(longTerm);

            shortTerm.addActionListener(this);
            mediumTerm.addActionListener(this);
            longTerm.addActionListener(this);

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.add(title);
            this.add(buttons);


        }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String actionCommand = evt.getActionCommand();
        System.out.println("Click " + evt.getActionCommand());
        if (actionCommand.equals(loggedInViewModel.SHORT_BUTTON_LABEL)) {
            showUseCaseView();
        } else if (actionCommand.equals(loggedInViewModel.MEDIUM_BUTTON_LABEL)) {
            showUseCaseView();
        } else if (actionCommand.equals(loggedInViewModel.LONG_BUTTON_LABEL)) {
            showUseCaseView();
        }
    }

    private void showUseCaseView(JPanel useCaseView) {
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

