package view;

import app.Main;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertNotNull;

public class LoggedInTest {

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

    // Helper methods:

    /**
     * Get the button at the given index.
     * @param buttonIndex The placement of the button (beginning at index 0).
     * @return The button in index buttonIndex.
     */
    private static JButton getButton(int buttonIndex) {
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
    private static JPanel getButtonsPanel(JFrame app) {
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

}
