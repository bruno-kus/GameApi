package Game;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel {
    AbstractFrame frame;
    public AbstractPanel(AbstractFrame frame) {
        super();
        this.frame = frame;
    }
}
