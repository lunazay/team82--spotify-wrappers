package view;

import app.Main;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;

public class LoginTest {

    /**
     * Verify that the desired button is present.
     * @param buttonIndex The placement of the button (beginning at index 0).
     * @return The button in index buttonIndex.
     */
    public JButton getButton(int buttonIndex) {
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
     * Helper method to return the buttons panel from the LoginView.
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
        LoginView loginView = (LoginView) jPanel2.getComponent(0);
        // Component 0 is the label of the window, Component 1 is the input field, Component 2 is the buttons
        return (JPanel) loginView.getComponent(2);
    }

    /**
     * Tests that the "Start" button appears and is where it should be.
     */
    @org.junit.Test
    public void testStartButton() {
        Main.main(null);
        JButton button = getButton(0);
        assert(button.getText().equals("Start"));
    }

    /**
     * Tests that the "Log in" button appears and is where it should be.
     */
    @org.junit.Test
    public void testLogInButton() {
        Main.main(null);
        JButton button = getButton(1);
        assert(button.getText().equals("Log in"));
    }

    /**
     * Tests that the "Cancel" button appears and is where it should be.
     */
    @org.junit.Test
    public void testCancelButton() {
        Main.main(null);
        JButton button = getButton(2);
        assert(button.getText().equals("Cancel"));
    }
}
