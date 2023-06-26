package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends MyPanel {
    public GameMenu(AbstractGameFrame frame) {
        super(frame);
        setLayout(new GridLayout(0, 1));
        setPreferredSize(new Dimension(400, 400));

        // menu label
        JLabel title = new JLabel("Main menu");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // play button
        JButton playButton = new JButton("Play");
        playButton.setFocusPainted(false);

        // settings button
        JButton settingsButton = new JButton("Settings");
        settingsButton.setFocusPainted(false);

        // listeners
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.renderGame();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.renderSettings();
            }
        });

        add(playButton);
        add(settingsButton);
    }
}
