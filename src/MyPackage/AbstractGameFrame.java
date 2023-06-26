package MyPackage;

import Windows.InFrameImp;
import Windows.WindowsImp;

import javax.swing.*;

public abstract class AbstractGameFrame extends JFrame {
    WindowsImp imp;
    public JPanel currentScreen;

    AbstractGameFrame(String title, WindowsImp imp) {
        super(title);
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
