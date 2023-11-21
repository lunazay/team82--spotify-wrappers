package view;

import interface_adapter.ViewModel;
import interface_adapter.get_valence.GetValenceState;
import interface_adapter.get_valence.GetValenceViewModel;

import interface_adapter.related_artists.RelatedArtistsState;
import interface_adapter.related_artists.RelatedArtistsViewModel;

import interface_adapter.top_artists.TopArtistsState;
import interface_adapter.top_artists.TopArtistsViewModel;

import interface_adapter.top_album.TopAlbumState;
import interface_adapter.top_album.TopAlbumViewModel;

import interface_adapter.top_songs.TopSongsState;
import interface_adapter.top_songs.TopSongsViewModel;

import interface_adapter.top_genre.TopGenreState;
import interface_adapter.top_genre.TopGenreViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {
        public final String viewName = "logged in";
        private final ViewModel viewModel;
        final JButton shortTerm;
        final JButton mediumTerm;
        final JButton longTerm;

        public LoggedInView(ViewModel loggedInViewModel){
            this.viewModel = loggedInViewModel;
            this.viewModel.addPropertyChangeListener(this);

            JLabel title = new JLabel("Logged In Screen");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel buttons = new JPanel();
            shortTerm = new JButton(loggedInViewModel.SHORT_BUTTON_LABEL);
            buttons.add(shortTerm);

            mediumTerm = new JButton(loggedInViewModel.MEDIUM_BUTTON_LABEL);
            buttons.add(mediumTerm);

            longTerm = new JButton(loggedInViewModel.LONG_BUTTON_LABEL);
            buttons.add(longTerm);

            shortTerm.addActionListener(this);
            mediumTerm.addActionListener(this);
            longTerm.addActionListener(this);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

