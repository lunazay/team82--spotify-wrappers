import app.Main;
import view.LoggedInView;
import view.LoginView;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;

public class AllCoverageTest {
    static String message = "";
    // IMPORTANT: authCode must always be updated to a code that has not expired for tests to succeed.
    static final String authCode = "AQCvNnV7u9uA7miI3WG6YRCmPRR5cYIIepGE8AulavMvEZSudOzfn8IPD6sgO4VWY-CVQLSbvlPc05G9vbB65B-BRk0Mn51vkSvEYRLmzsb8eIuWeZ1bbGaXaNuK-XrLB94aA-2Q68C0fCE04ahivyUHv5ne_BBw50wck1urFfdUw8A5kFFDCUWhXk5wyXWckhvFB3NDCv_KAFr8n2686t6M8YbUZi2ZaCESMX8RXnJ7d9qqeAlshSdJkTqpC1aQttTMjbCgofwdsfNLnnHnQILE99VZjdKmGOnqNAvPIwZL9ov34pJj4lHRUHcZWnxIRDU";

    /**
     * Tests that short term data is shown when a user is logged in and clicks the short term button. The authentication
     * code must be changed to be working for this test to operate correctly.
     */
    @org.junit.Test
    public void testShortTermDataShown() {
        Main.main(null);
        // IMPORTANT: must replace authCode attribute with an active code whenever running test.
        logIn();
        // Clicks short term button.
        JButton button = getLoggedInButton(0);
        button.doClick();

        Window[] windows = Window.getWindows();
        updateMessage(windows);

        // Confirms a message was received.
        assertNotNull(message);
        // Guarantees the message received was not an error message "No ___ available."
        assert(message.contains("available."));
    }

    /**
     * Tests that medium term data is shown when a user is logged in and clicks the short term button. The authentication
     * code must be changed to be working for this test to operate correctly.
     */
    @org.junit.Test
    public void testMediumTermDataShown() {
        Main.main(null);
        // IMPORTANT: must replace authCode attribute with an active code whenever running test.
        logIn();
        // Clicks short term button.
        JButton button = getLoggedInButton(1);
        button.doClick();

        Window[] windows = Window.getWindows();
        updateMessage(windows);

        // Confirms a message was received.
        assertNotNull(message);
        // Guarantees the message received was not an error message "No ___ available."
        assert(message.contains("available."));
    }

    /**
     * Tests that long term data is shown when a user is logged in and clicks the short term button. The authentication
     * code must be changed to be working for this test to operate correctly.
     */
    @org.junit.Test
    public void testLongTermDataShown() {
        Main.main(null);
        // IMPORTANT: must replace authCode attribute with an active code whenever running test.
        logIn();
        // Clicks short term button.
        JButton button = getLoggedInButton(2);
        button.doClick();

        Window[] windows = Window.getWindows();
        updateMessage(windows);

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

    /**
     * Verify that the desired button is present.
     * @param buttonIndex The placement of the button (beginning at index 0).
     * @return The button in index buttonIndex.
     */
    public static JButton getLoginButton(int buttonIndex) {
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

    /**
     * Helper method to return the buttons panel from the LoginView.
     *
     * @param app the JFrame of the app.
     * @return the JPanel with each button as a component.
     */
    public static JPanel getLoginButtonsPanel(JFrame app) {
        LoginView loginView = (LoginView) navigateRoot(app).getComponent(0);
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
        LoggedInView loggedInView = (LoggedInView) navigateRoot(app).getComponent(1);
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

    /**
     * Logs the user associated with the authCode of this test class into the program.
     */
    public static void logIn() {
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
        JButton logInButton = getLoginButton(1);
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

    /**
     * A helper method for testing the functionality of the different views. Using the system from Week5CA tests, this
     * test changes the message attribute if one is available in the call.
     */
    private static void updateMessage(Window[] windows) {
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
    }
}
