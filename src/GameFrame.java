import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class GameFrame extends JFrame {

    private JPanel currentScreen;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        renderMenu();
        getContentPane().add(currentScreen);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void renderMenu() {
        getContentPane().removeAll();
        currentScreen = new GameMenu(this);
        getContentPane().add(currentScreen);
        revalidate();
        repaint();
    }

    public void renderGame() {
        getContentPane().removeAll();
        currentScreen = new GameContent(this);
        getContentPane().add(currentScreen);
        revalidate();
        repaint();
    }
}