package view;

import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.LoggedInState;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO: do we need to add anything here? if so, what?
    }
}

