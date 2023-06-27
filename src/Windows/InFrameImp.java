package Windows;

import Game.*;
import Utilities.Utilities;

import javax.swing.*;


public class InFrameImp implements WindowsImp {
    @Override
    public void impRenderMenu(AbstractFrame frame) {
        renderFrame(frame, Utilities.buildScreen(frame.menu, frame));
    }

    @Override
    public void impRenderSettings(AbstractFrame frame) {
        // tu będą jeszce problemy dotyczące settingsów
        // dostępności, itd
        // czy każde settings mają dostęp do ramki?
        // tak
        // to w sumie spoko
        // wychodzi na to że każdy obiekt mający dostęp do ramki
        // ma też dostęp do wszystkich paneli
        // to całkiem wygodne!
        renderFrame(frame, Utilities.buildScreen(frame.settings, frame));
    }

    @Override
    public void impRenderGame(AbstractFrame frame) {
        // i podobnie tu, z displayem, display też ma dostęp do ramki, a co za tym idzie
        // do wszystkiego
            renderFrame(frame, Utilities.buildScreen(frame.display, frame));
    }


    public void renderFrame(AbstractFrame frame, AbstractPanel panel) {

        if (frame.getContentPane().isAncestorOf(frame.currentScreen)) {
            frame.getContentPane().remove(frame.currentScreen);
        }
        frame.currentScreen = panel;


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
