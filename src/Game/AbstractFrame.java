package Game;

import Game.Screens.AbstractDisplay;
import Game.Screens.AbstractMenu;
import Game.Screens.AbstractSettings;
import Utilities.Utilities;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractFrame extends JFrame {
    public AbstractPanel currentScreen;
    public Class<? extends AbstractMenu> menu;
    public Class<? extends AbstractSettings> settings;
    public Class<? extends AbstractDisplay> display;
    public AbstractProgramConfig config;
    public RendererConfig rendererConfig;
    public AbstractFrame(
            String title,
            Class<? extends AbstractMenu> menu,
            Class<? extends AbstractSettings> settings,
            Class<? extends AbstractDisplay> display,
            AbstractProgramConfig config,
            RendererConfig rendererConfig) {
        super(title);
        this.menu = menu;
        this.settings = settings;
        this.display = display;
        this.config = config;
        this.rendererConfig = rendererConfig;
    }
    public void renderMenu() {
        switch (rendererConfig.menu) {
            case 0 -> renderInFrame(menu);
            case 1 -> renderInDialog(menu);
        }
    }
    public void renderSettings() {
        switch (rendererConfig.settings) {
            case 0 -> renderInFrame(settings);
            case 1 -> renderInDialog(settings);
        }
    }
    public void renderDisplay() {
        switch (rendererConfig.display) {
            case 0 -> renderInFrame(display);
            case 1 -> renderInDialog(display);
        }
    }
    public void renderInDialog(Class<? extends AbstractPanel> clazz) {
        AbstractPanel screen = Utilities.buildScreen(clazz, this);

        JDialog dialog = new JDialog(this);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(this);
        dialog.pack();
        dialog.setVisible(true);

        dialog.setContentPane(screen);
    }
    public void renderInFrame(Class<? extends AbstractPanel> clazz) {

        AbstractPanel screen = Utilities.buildScreen(clazz, this);
        if (getContentPane().isAncestorOf(currentScreen)) {
            getContentPane().remove(currentScreen);
        }
        currentScreen = screen;

        getContentPane().add(currentScreen);

        revalidate();
        repaint();
    }
}
