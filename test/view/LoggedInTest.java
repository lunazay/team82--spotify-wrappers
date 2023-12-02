package view;

import app.Main;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;

public class LoggedInTest {

    /**
     * Get the button at the given index.
     * @param buttonIndex The placement of the button (beginning at index 0).
     * @return The button in index buttonIndex.
     */
    public static JButton getButton(int buttonIndex) {
        JFrame app = null;

        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        // Test fails if the window does not appear.
        assertNotNull(app);
        JPanel buttons = getButtonsPanel(app);

        return (JButton) buttons.getComponent(buttonIndex);
    }

    /**
     * Helper method to return the buttons panel from the LoggedInView.
     *
     * @param app the JFrame of the app.
     * @return the JPanel with each button as a component.
     */
    public static JPanel getButtonsPanel(JFrame app) {
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
     * Helper method to return the input text field from the LoginView.
     *
     * @param app the JFrame of the app.
     * @return the JTextField to input the authentication code into.
     */
    public static JTextField getLogInInputTextField(JFrame app) {
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
        JPanel inputField = (JPanel) loginView.getComponent(1);
        // Component 0 is the text field label, Component 1 is the text field itself
        return (JTextField) inputField.getComponent(1);
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
     * Tests that the Short term button appears and is where it should be.
     */
    @org.junit.Test
    public void testShortTermButton() {
        Main.main(null);
        JButton button = getButton(0);
        assert(button.getText().equals("Short term"));
    }

    /**
     * Tests that the Medium term button appears and is where it should be.
     */
    @org.junit.Test
    public void testMediumTermButton() {
        Main.main(null);
        JButton button = getButton(1);
        assert(button.getText().equals("Medium term"));
    }

    /**
     * Tests that the Long term button appears and is where it should be.
     */
    @org.junit.Test
    public void testLongTermButton() {
        Main.main(null);
        JButton button = getButton(2);
        assert(button.getText().equals("Long term"));
    }

    /**
     * Tests that the Done button appears and is where it should be.
     */
    @org.junit.Test
    public void testDoneButton() {
        Main.main(null);
        JButton button = getButton(3);
        assert(button.getText().equals("Done"));
    }

    /**
     * Tests that short term data is shown when a user is logged in and clicks the short term button. The authentication
     * code must be changed to be working for this test to operate correctly.
     */
    @org.junit.Test
    public void testShortTermDataShown() {
        Main.main(null);
        // IMPORTANT: must replace below with an active code whenever running test.
        logIn(authCode);
        // Clicks short term button.
        JButton button = getButton(0);
        button.doClick();

        Window[] windows = Window.getWindows();
        for (Window window : windows) {

            if (window instanceof JDialog) {

                JDialog dialog = (JDialog) window;

                if (dialog.isVisible()) {
                    String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                            .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                    System.out.println("message = " + s);

                    LoggedInTest.message = s;

                    System.out.println("disposing of..." + window.getClass());
                    window.dispose();
                }
            }
        }

        // Confirms a message was received.
        assertNotNull(message);
        // Guarantees the message received was not an error message "No ___ available."
        assert(!message.contains("available."));
    }
}
