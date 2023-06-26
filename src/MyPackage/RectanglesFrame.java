package MyPackage;

import Archive.Difficulty;
import Windows.InFrameImp;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class RectanglesFrame extends AbstractGameFrame {
    int timeLimit = 30;
    double goal = 0.5;
    int speed = 10;
    int side = 100;

    public int frequency = 10;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RectanglesFrame();
            }
        });
    }

    public RectanglesFrame() {
        super("Rectangles", new InFrameImp());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        renderMenu();


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}