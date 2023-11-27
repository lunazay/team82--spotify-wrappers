package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private String url = "https://developer.spotify.com";

    final JTextField codeInputField = new JTextField(15);

    final JButton logIn;
    final JButton cancel;
    public LoginView(LoginViewModel loginViewModel, LoginController controller){
        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel buttons = new JPanel();
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        cancel = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // JPanel loginPanel = loginViewModel.getViewPanel();
        //add(loginPanel);

        logIn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {

                        if (evt.getSource().equals(logIn)){
                            LoginState currentState = loginViewModel.getState();
                            try {
                                loginController.execute(currentState.getCode());
                                openLink("https://developer.spotify.com"); // Replace with your URL
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                    }
                    // TODO: we need to figure out what the input data needs to be before finishing this. ;
                }

            }
        }
        );
        cancel.addActionListener(this);

        codeInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setCode(codeInputField.getText());
                loginViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    private void openLink(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                // Handle the exception (e.g., show an error message)
            }
        } else {
            // Desktop not supported, handle this case
            // You can also provide an alternative method to open the link in this case
            // For example, show a message to the user to copy-paste the link into their browser
        }
    }
    
    public void actionPerformed(ActionEvent evt) {
        LoginState currentState = loginViewModel.getState();
        String stateCode = currentState.getCode();
        JOptionPane.showMessageDialog(this, stateCode);
        System.out.println("Click" + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state){
        //TODO: figure out after the input data is figured out.
    }

    public String getViewname(){
        return viewname;
    }
}
