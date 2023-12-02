import app.Main;
import view.LoggedInTest;
import view.LoggedInView;
import view.LoginTest;
import view.LoginView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;

public class TestingAllCoverage {
    static String message = "";
    // IMPORTANT: authCode must always be updated to a code that has not expired for tests to succeed.
    static final String authCode = "AQBFhyasnxIfwlafelZMupt0_M8qHcr5e1HhuUiZP3AqUmAuucmgKmr23fRa8bM87CcmufJYDxrOiA0h1DV5yZCoetQI8x6f105TTOksPAnpNNerRC00wTr9654IPzP-dQ0gZOZd07FKxyiCQnArY7-aUJyfx6wmOltWy6ROLVU3wUkI4suStb6F-4Hh-zhOfMJTzj71HnDZYU7zaxeDi3ZFX5cbY7axCnqruS9I1V1GPFvRv4i5L470RXSr0jO9XkONoFqcv8A3pGiMH0mg2aO9thHuPiIZRK7Szbno7DjaLXfXs7oJtlv3zJunIyKB2nA";

    @org.junit.Test
    public void testShortTermDataShown() {
        Main.main(null);
        // IMPORTANT: must replace below with an active code whenever running test.
        LoggedInTest.logIn(authCode);
        // Clicks short term button.
        JButton button = LoggedInTest.getButton(0);
        button.doClick();

        // From Week5CA clear users test:
        Window[] windows = Window.getWindows();
        for (Window window : windows) {

            if (window instanceof JDialog) {

                JDialog dialog = (JDialog) window;

                if (dialog.isVisible()) {
                    String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                            .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                    System.out.println("message = " + s);

                    message = s;

                    System.out.println("disposing of..." + window.getClass());
                    window.dispose();
                }
            }
        }

        // Confirms a message was received.
        assertNotNull(message);
        // Guarantees the message received was not an error message "No ___ available."
        assert(message.contains("available."));
    }

    //
    //
    // Helper methods:
    //
    //

    public JButton getLoginButton(int buttonIndex) {
        JFrame app = null;

        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        // Test fails if the window does not appear.
        assertNotNull(app);
        JPanel buttons = getLoginButtonsPanel(app);

        return (JButton) buttons.getComponent(buttonIndex);
    }

    public static JPanel getLoginButtonsPanel(JFrame app) {
        // Root of the app
        Component root = app.getComponent(0);
        // All the content of the window
        Component cp = ((JRootPane) root).getContentPane();
        // Panel Version of the Content Pane
        JPanel jPanel1 = (JPanel) cp;
        // The Component of the Panel contains the information on the page
        JPanel jPanel2 = (JPanel) jPanel1.getComponent(0);
        // Component 0 is LoginView, Component 1 is LoggedInView
        LoginView loginView = (LoginView) jPanel2.getComponent(0);
        // Component 0 is the label of the window, Component 1 is the input field, Component 2 is the buttons
        return (JPanel) loginView.getComponent(2);
    }

    /**
     * Helper method to return the buttons panel from the LoggedInView.
     *
     * @param app the JFrame of the app.
     * @return the JPanel with each button as a component.
     */
    public static JPanel getLoggedInButtonsPanel(JFrame app) {
        // Root of the app
        Component root = app.getComponent(0);
        // All the content of the window
        Component cp = ((JRootPane) root).getContentPane();
        // Panel Version of the Content Pane
        JPanel jPanel1 = (JPanel) cp;
        // The Component of the Panel contains the information on the page
        JPanel jPanel2 = (JPanel) jPanel1.getComponent(0);
        // Component 0 is LoginView, Component 1 is LoggedInView
        LoggedInView loggedInView = (LoggedInView) jPanel2.getComponent(1);
        // Component 0 is the label of the window, Component 1 is the buttons
        return (JPanel) loggedInView.getComponent(1);
    }

    /**
     * Get the button at the given index.
     * @param buttonIndex The placement of the button (beginning at index 0).
     * @return The button in index buttonIndex.
     */
    public static JButton getLoggedInButton(int buttonIndex) {
        JFrame app = null;

        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        // Test fails if the window does not appear.
        assertNotNull(app);
        JPanel buttons = getLoggedInButtonsPanel(app);

        return (JButton) buttons.getComponent(buttonIndex);
    }

    public static void logIn(String authCode) {
        JFrame app = null;

        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        // Test fails if the window does not appear.
        assertNotNull(app);
        // Gets the input text field on the login screen
        JTextField inputTextField = getLogInInputTextField(app);

        // Sets the input text field to have the authentication code.
        inputTextField.setText(authCode);
        // Gets and clicks the Log in button.
        JButton logInButton = (JButton) LoginTest.getButtonsPanel(app).getComponent(1);
        logInButton.doClick();
    }

    /**
     * Helper method to return the input text field from the LoginView.
     *
     * @param app the JFrame of the app.
     * @return the JTextField to input the authentication code into.
     */
    public static JTextField getLogInInputTextField(JFrame app) {
        LoginView loginView = (LoginView) navigateRoot(app).getComponent(0);
        // Component 0 is the label of the window, Component 1 is the input field, Component 2 is the buttons
        JPanel inputField = (JPanel) loginView.getComponent(1);
        // Component 0 is the text field label, Component 1 is the text field itself
        return (JTextField) inputField.getComponent(1);
    }

    /**
     * Navigates from the root of the app to the JPanel where the LoginView and LoggedInView are accessed. Reduces
     * code redundancy.
     * @param app the JFrame of the app
     * @return a JPanel with its component at index 0 being LoginView and its component at index 1 being LoggedInView
     */
    private static JPanel navigateRoot(JFrame app) {
        // Root of the app
        Component root = app.getComponent(0);
        // All the content of the window
        Component cp = ((JRootPane) root).getContentPane();
        // Panel Version of the Content Pane
        JPanel jPanel = (JPanel) cp;
        // The Component of the Panel contains the information on the page
        // Component 0 is LoginView, Component 1 is LoggedInView
        return (JPanel) jPanel.getComponent(0);
    }
}
