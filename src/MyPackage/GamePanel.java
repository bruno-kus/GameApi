package MyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

class GamePanel extends JPanel {

    RectanglesContent rc;
    java.util.List<Rectangle> rectangles = new ArrayList<>();
    int killedCount = 0;
    int totalCount = 0;
    Timer clock;
    Timer timer;

    int elapsedTime = 0;
    boolean generatingRectangles = true;

    GamePanel(RectanglesContent rc) {
        this.rc = rc; // jest potrzebne, żeby widziały różne podklasy z własnym stackiem
//        this.rc = (RectanglesContent) getParent(); nie zadziała bo zanim dodam do rodzica, muszę wyjść z konstruktora

        
        setPreferredSize(new Dimension(400, 400));
        setSize(getPreferredSize());
        setBackground(Color.ORANGE);


        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                if (elapsedTime == rc.frame.timeLimit) {
                    timer.stop();
                    generatingRectangles = false;
                }
            }
        });
        clock = new Timer(rc.frame.speed, new RectangleMover());
        addMouseListener(new RectangleKiller());
        timer.start();
        clock.start();
    }
    class RectangleMover implements ActionListener {
        int counter;
        @Override
        public void actionPerformed(ActionEvent e) {
            // generate rectangles
            if (generatingRectangles) {
                if (counter % rc.frame.frequency == 0) {
                    generateRectangle();
                    totalCount++;
                }
            } else if (rectangles.size() == 0) {
                endGame();
                return;
            }
            moveRectangles();
            counter++;
        }
    }
    void generateRectangle() {
        int x = new Random().nextInt(getWidth() - rc.frame.side + 1);
        int y = 0;
        int width = rc.frame.side;
        int height = rc.frame.side;
        Rectangle newRect = new Rectangle(x, y, width, height);
        rectangles.add(newRect);
    }
    void moveRectangles() {
        java.util.List<Rectangle> newRectangles = new ArrayList<>();
        for (Rectangle r : rectangles) {
            r.y += 1;
            if (r.y < getHeight()) {
                newRectangles.add(r);
            }
        }
        rectangles = newRectangles;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Rectangle r : rectangles) {
            g.setColor(Color.blue);
            g.fillRect(r.x, r.y, r.width, r.height);
            g.setColor(Color.white);
            g.drawRect(r.x, r.y, r.width, r.height);
        }
        updateLabels();
    }
    void updateLabels() {
        rc.timeLabel.setText(
                "Time left: " +  (rc.frame.timeLimit - elapsedTime) + "s"
        );
        rc.scoreLabel.setText(
                "Current score: " + percent.format(getScore()) + "\n" +
                        "Killed: " + killedCount + "\n" +
                        "Total: " + totalCount
        );
    }
    static final DecimalFormat percent = new DecimalFormat("0%");
    double getScore() {
        return (double) killedCount / totalCount;
    }
    class RectangleKiller extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            for (int i = 0; i < rectangles.size(); i++) {
                Rectangle rect = rectangles.get(i);
                if (rect.contains(p)) {
                    rectangles.remove(i);
                    killedCount++;
                    repaint();
                    break;
                }
            }
        }
    }
    void endGame() {
        clock.stop();

        String result = getScore() >= rc.frame.goal ? "You won!" : "You lost!";
        String score = percent.format(getScore());
        String message =  result + " Score: " + score;

        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(this, "Game finished");
        dialog.setLocationRelativeTo(getParent());
        dialog.setVisible(true);

        ((RectanglesContent)getParent()).enableReset();
        getParent().revalidate();
    }
}