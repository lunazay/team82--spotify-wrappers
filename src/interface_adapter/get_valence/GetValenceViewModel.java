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
        // Create and configure the JPanel for the valence view
        JPanel getValencePanel = new JPanel();
        getValencePanel.setLayout(new BorderLayout());

        // Add components representing the view
        JLabel titleLabel = new JLabel("Valence"); // Update label accordingly
        getValencePanel.add(titleLabel, BorderLayout.NORTH);

        // Retrieve the valence value from the state
        String valence = state.getValence();

        if (!valence.isEmpty() && valence != ""){
            JLabel valenceLabel = new JLabel(valence);
            getValencePanel.add(valenceLabel, BorderLayout.CENTER);
        } else {
            JLabel noDataLabel = new JLabel("No Valence available.");
            getValencePanel.add(noDataLabel, BorderLayout.CENTER);
        }

        // Display the valence value in the view
        return getValencePanel;
    }
}
