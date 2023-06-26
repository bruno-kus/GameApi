package Windows;

import MyPackage.*;

import javax.swing.*;

public class InFrameImp implements WindowsImp {
    @Override
    public void impRenderMenu(AbstractGameFrame frame) {
        renderFrame(frame, new GameMenu(frame));
    }

    @Override
    public void impRenderSettings(AbstractGameFrame frame) {
        renderFrame(frame, new RectangleSettingsScreen(frame));
    }

    @Override
    public void impRenderGame(AbstractGameFrame frame) {
        renderFrame(frame, new RectanglesContent(frame));
    }


    public void renderFrame(AbstractGameFrame frame, JPanel screen) {

        if (frame.getContentPane().isAncestorOf(frame.currentScreen)) {
            frame.getContentPane().remove(frame.currentScreen);
        }
        frame.currentScreen = screen;


        frame.getContentPane().add(frame.currentScreen);


        frame.revalidate();
        frame.repaint();
    }
}
/*
public void renderMenu() {

    }

    public void renderGame() {
        getContentPane().removeAll();
        currentScreen = new GameContent(this);
        getContentPane().add(currentScreen);
        revalidate();
        repaint();
    }
 */
