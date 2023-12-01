package view;

import app.LoggedInUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.top_artists.TopArtistsViewModel;
import interface_adapter.top_genre.TopGenreViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
import java.util.ArrayList;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;
    private String url = "https://accounts.spotify.com/authorize?client_id=bad90b33466e4f208c7655eede3ac628&response_type=code&redirect_uri=https://oauth.pstmn.io/v1/browser-callback&scope=user-read-private%20user-read-email%20user-top-read%20playlist-modify-public%20playlist-modify-private&";
    final JTextField codeInputField = new JTextField(15);

    final JButton logIn;
    final JButton cancel;
    final JButton start;
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
        start = new JButton(loginViewModel.START_BUTTON_LABEL);
        buttons.add(start);
        logIn = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        cancel = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        // JPanel loginPanel = loginViewModel.getViewPanel();
        //add(loginPanel);

        logIn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        String actionCommand = evt.getActionCommand();
                        System.out.println("Click " + evt.getActionCommand());

                        if (evt.getSource().equals(logIn)){
                            ViewManagerModel viewManagerModel = new ViewManagerModel();
                            LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

                            System.out.println("i made it to log in view");
                            LoginState currentState = loginViewModel.getState();
                            try {
                                loginController.execute(currentState.getCode());

                                displayOutput();
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
        //TODO: figure out after the input data is figured out.
    }

    public String getViewname(){
        return viewname;
    }

    public void displayOutput() {
        StringBuilder topgenres = new StringBuilder();
        TopGenreViewModel topGenreViewModel = new TopGenreViewModel();
        ArrayList<String> outputList = topGenreViewModel.getState().getGenres();
        for (String user : outputList) {
            topgenres.append(user).append(",");

        }
        JOptionPane.showMessageDialog(this, "top Genres:" + topgenres);

    }
    }


