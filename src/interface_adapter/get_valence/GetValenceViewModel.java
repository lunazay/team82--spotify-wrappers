package interface_adapter.get_valence;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GetValenceViewModel extends ViewManagerModel {

    private GetValenceState state = new GetValenceState();

    public void setState(GetValenceState state) { this.state = state; }

    public GetValenceState getState() { return this.state; }

    public JPanel getViewPanel() {
        // Create and configure the JPanel for the top genre view
        JPanel getValencePanel = new JPanel();
        getValencePanel.setLayout(new BorderLayout());

        // Add components representing the view
        JLabel titleLabel = new JLabel("Valence"); // Update label accordingly
        getValencePanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the valence value from the state
        String valence = state.getValence();

        // Display the valence value in the view
        JLabel valenceLabel = new JLabel(valence != null ? valence : "No valence available");
        valenceLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the label
        getValencePanel.add(valenceLabel, BorderLayout.CENTER);

        return getValencePanel;
    }
}
