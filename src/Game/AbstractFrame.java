package Game;

import Game.Screens.AbstractDisplay;
import Game.Screens.AbstractMenu;
import Game.Screens.AbstractSettings;
import Utilities.Utilities;
import Windows.WindowsImp;

import javax.swing.*;

public abstract class AbstractFrame extends JFrame {
    WindowsImp imp;
    public AbstractPanel currentScreen;

    public Class<? extends AbstractMenu> menu;
    public Class<? extends AbstractSettings> settings;
    public Class<? extends AbstractDisplay> display;
    public AbstractConfig config;
    public AbstractFrame(
            String title,
            Class<? extends AbstractMenu> menu,
            Class<? extends AbstractSettings> settings,
            Class<? extends AbstractDisplay> display,
            AbstractConfig config,
            WindowsImp imp) {
        super(title);
        this.menu = menu;
        this.settings = settings;
        this.display = display;
        this.config = config;
        this.imp = imp;
    }

    public void renderFrame(Class<? extends AbstractPanel> panelClass) {

        AbstractPanel screen = Utilities.buildScreen(panelClass, this);
        if (getContentPane().isAncestorOf(currentScreen)) {
            getContentPane().remove(currentScreen);
        }
        currentScreen = screen;

        getContentPane().add(currentScreen);

        revalidate();
        repaint();
    }
}
