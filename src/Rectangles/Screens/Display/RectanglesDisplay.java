package Rectangles.Screens.Display;

import Game.Screens.AbstractDisplay;
import Game.AbstractFrame;
import Rectangles.RectanglesFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectanglesDisplay extends AbstractDisplay {

    RectanglesFrame frame;
    public JLabel timeLabel;
    public JLabel scoreLabel;
    public JPanel southPanel;

    public RectanglesDisplay(AbstractFrame frame) {
        super(frame);
        this.frame = (RectanglesFrame) frame;
        setLayout(new BorderLayout());

        JPanel centerPanel = new RectanglesViewport(this, frame.config);
        southPanel = new JPanel(new GridLayout(0, 1));
        JPanel labelsPanelContainer = new JPanel();
        JPanel labelsPanel = new JPanel();

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(labelsPanelContainer);
        labelsPanelContainer.add(labelsPanel);

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitledBorder timeBorder = new TitledBorder("Time");
        timeLabel.setBorder(timeBorder);
        labelsPanel.add(timeLabel);

        scoreLabel = new JLabel();
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitledBorder scoreBorder = new TitledBorder("Score");
        scoreLabel.setBorder(scoreBorder);
        labelsPanel.add(scoreLabel);
    }

    public void enableReset() {
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.renderDisplay();
            }
        });
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.add(playAgainButton);
        southPanel.add(playAgainPanel);
    }
}