package Rectangles.Screens;

import Game.AbstractFrame;
import Game.Screens.AbstractMenu;

import javax.swing.*;
import java.awt.*;


public class RectanglesMenu extends AbstractMenu {
    public RectanglesMenu(AbstractFrame frame) {
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
        playButton.addActionListener(e -> frame.renderDisplay());

        settingsButton.addActionListener(e -> frame.renderSettings());

        add(playButton);
        add(settingsButton);
    }
}
