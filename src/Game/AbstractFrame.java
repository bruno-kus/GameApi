package Game;

import Game.Screens.AbstractDisplay;
import Game.Screens.AbstractMenu;
import Game.Screens.AbstractSettings;
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

    public void renderMenu() {
        imp.impRenderMenu(this);
    }

    public void renderGame() {
        imp.impRenderGame(this);
    }
    public void renderSettings() {
        imp.impRenderSettings(this);
    }
}
