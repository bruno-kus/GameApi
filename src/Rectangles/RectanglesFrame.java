package Rectangles;

import Game.AbstractFrame;
import Game.RendererConfig;
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
                new RectanglesProgramConfig(),
                new RendererConfig()
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        renderMenu();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}