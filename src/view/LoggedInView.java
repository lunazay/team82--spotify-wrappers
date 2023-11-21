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
        private final LoggedInViewModel viewModel;
        final JButton shortTerm;
        final JButton mediumTerm;
        final JButton longTerm;

        public LoggedInView(ViewModel loggedInViewModel){
            this.viewModel = loggedInViewModel;
            this.viewModel.addPropertyChangeListener(this);

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
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

