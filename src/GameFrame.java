import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    int timeLimit = 30;
    Difficulty difficulty;
    double goal = 0.5;
    int speed = 10;
    int side = 100;

    int frequency = 10;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameFrame();
            }
        });
    }

    public GameFrame() {
        super("Rectangles!");

        //
//        setLayout(new BorderLayout());
        //

        DifficultyDialog difficultyDialog = new DifficultyDialog(this);
        difficultyDialog.setLocationRelativeTo(this);
        difficultyDialog.setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new GameContent(this);
        add(contentPanel /*, BorderLayout.CENTER*/);

//        String settings = "time: " + timeLimit + "goal: " + goal + "speed: " + speed + "side: " + side + "frequency" + frequency;
//        add(new JLabel(settings), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}