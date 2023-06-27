package Rectangles.Screens.Display;


import Game.AbstractConfig;
import Rectangles.RectanglesConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class RectanglesViewport extends JPanel {

    RectanglesDisplay display;
    RectanglesConfig config;
    List<Rectangle> rectangles = new ArrayList<>();
    int killedCount = 0;
    int totalCount = 0;
    Timer clock;
    Timer timer;

    int elapsedTime = 0;
    boolean generatingRectangles = true;

    RectanglesViewport(RectanglesDisplay display, AbstractConfig config) {
        // tylko w środku konstruktora musze otwarcie używać podkreślać, że mam na myśli this.config
        // czy to czytelne rozwiązanie?

        this.display = display;

        this.config = (RectanglesConfig) config;

        
        setPreferredSize(new Dimension(400, 400));
        setSize(getPreferredSize());
        setBackground(Color.ORANGE);

        timer = new Timer(1000, e -> {
            elapsedTime++;
            if (elapsedTime == this.config.timeLimit) {
                timer.stop();
                generatingRectangles = false;
            }
        });

        clock = new Timer(this.config.speed, new RectangleMover());
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
                if (counter % config.frequency == 0) {
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
        int x = new Random().nextInt(getWidth() - config.side + 1);
        int y = 0;
        int width = config.side;
        int height = config.side;
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
        display.timeLabel.setText(
                "Time left: " +  (config.timeLimit - elapsedTime) + "s"
        );
        display.scoreLabel.setText(
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

        String result = getScore() >= config.goal ? "You won!" : "You lost!";
        String score = percent.format(getScore());
        String message =  result + " Score: " + score;

        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(this, "Game finished");
        dialog.setLocationRelativeTo(getParent());
        dialog.setVisible(true);

        ((RectanglesDisplay)getParent()).enableReset();
        getParent().revalidate();
    }
}