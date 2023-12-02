package interface_adapter.get_valence;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GetValenceViewModel extends ViewManagerModel {

    private GetValenceState state = new GetValenceState();

    public void setState(GetValenceState state) { this.state = state; }

    public GetValenceState getState() { return this.state; }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("ValenceState", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public JPanel getViewPanel() {
        // Create and configure the JPanel for the valence view
        JPanel getValencePanel = new JPanel();
        getValencePanel.setLayout(new BorderLayout());

        // Add components representing the view
        JLabel titleLabel = new JLabel("Valence"); // Update label accordingly
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, titleLabel.getFont().getSize())); // Set font to bold
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
