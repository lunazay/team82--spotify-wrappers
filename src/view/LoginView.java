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

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "log in";
    private final LoginViewModel loginViewModel;
    private final LoginController loginController;

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

        logIn.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)){
                            LoginState currentState = loginViewModel.getState();
                            try {
                                loginController.execute(currentState.getCode());
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
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
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
