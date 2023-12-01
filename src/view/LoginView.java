package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private final String url = "https://accounts.spotify.com/authorize?client_id=bad90b33466e4f208c7655eede3ac628&response_type=code&redirect_uri=https://oauth.pstmn.io/v1/browser-callback&scope=user-read-private%20user-read-email%20user-top-read%20playlist-modify-public%20playlist-modify-private&";
    final JTextField codeInputField = new JTextField(15);

    final JButton logIn;
    final JButton cancel;
    final JButton start;

    /**
     * Creates the LoginView with buttons to Start, Log In, and Exit and a field to input the authentication code.
     * The Start button opens the Spotify authentication link in the user's browser to retrieve an authentication code.
     */
    public LoginView(LoginViewModel loginViewModel, LoginController controller){
        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel codeInputInfo = new JPanel();
        codeInputInfo.add(new JLabel("Code input"));
        codeInputInfo.add(codeInputField);

        JPanel buttons = new JPanel();
        start = new JButton(LoginViewModel.START_BUTTON_LABEL);
        buttons.add(start);
        logIn = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        cancel = new JButton(LoginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // JPanel loginPanel = loginViewModel.getViewPanel();
        //add(loginPanel);

        logIn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String actionCommand = evt.getActionCommand();
                        System.out.println("Click " + evt.getActionCommand());

                        if (evt.getSource().equals(logIn)){
                            LoginState currentState = loginViewModel.getState();
                            try {
                                loginController.execute(currentState.getCode());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                    }
                }

            }
        }
        );
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String actionCommand = evt.getActionCommand();
                System.out.println("Click " + evt.getActionCommand());
                // Action for the "Cancel" button
                int confirmExit = JOptionPane.showConfirmDialog(LoginView.this, "Are you sure you want to exit?");
                if (confirmExit == JOptionPane.YES_OPTION) {
                    // Perform necessary cleanup and exit the application
                    System.exit(0); // Terminate the application
                }
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(start)) {
                    Desktop desktop = Desktop.getDesktop();
                    try { URI uri = new URI(url);
                    desktop.browse(uri);}
                    catch (URISyntaxException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        codeInputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTextField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components don't fire these events
            }

            private void updateTextField() {
                LoginState currentState = loginViewModel.getState();
                currentState.setCode(codeInputField.getText());
                loginViewModel.setState(currentState);
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(codeInputInfo);
        this.add(buttons);
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
        codeInputField.setText(state.getCode());
    }
}
