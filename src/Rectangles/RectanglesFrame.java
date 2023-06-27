package Rectangles;

import Game.AbstractFrame;
import Rectangles.Screens.Display.RectanglesDisplay;
import Rectangles.Screens.RectanglesMenu;
import Rectangles.Screens.RectanglesSettings;
import Windows.InFrameImp;
import javax.swing.*;

public class RectanglesFrame extends AbstractFrame {
    public RectanglesFrame() {
        super(
                "Rectangles",
                RectanglesMenu.class,
                RectanglesSettings.class,
                RectanglesDisplay.class,
                new RectanglesConfig(),
                new InFrameImp()
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        renderMenu();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}