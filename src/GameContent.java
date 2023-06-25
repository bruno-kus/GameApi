import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameContent extends JPanel {

    GameFrame gf;
    JLabel timeLabel;
    JLabel scoreLabel;
    JPanel southPanel;

    GameContent(GameFrame gf) {
        this.gf = gf;
        setLayout(new BorderLayout());

        JPanel centerPanel = new GamePanel(this);
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

    void enableReset() {
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gf.dispose();
                new GameFrame();
            }
        });
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.add(playAgainButton);
        southPanel.add(playAgainPanel);
    }
}