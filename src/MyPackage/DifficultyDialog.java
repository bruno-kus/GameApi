package MyPackage;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;



class DifficultyDialog extends JDialog {
    RectanglesFrame gf = (RectanglesFrame)getOwner();
    public DifficultyDialog(Frame parent) {
        super(parent);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");
        JButton impossibleButton = new JButton("Impossible");

        // Frequency slider
        JSlider freqSlider = new JSlider(10, 40, 25);
        freqSlider.setMajorTickSpacing(5);
        freqSlider.setPaintLabels(true);
        freqSlider.setPaintTicks(true);
        freqSlider.setSnapToTicks(true);
        freqSlider.setOrientation(SwingConstants.VERTICAL);

        TitledBorder freqBorder = new TitledBorder("Choose frequency:");
        freqBorder.setTitleJustification(TitledBorder.CENTER);
        freqSlider.setBorder(freqBorder);

        freqSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gf.frequency = freqSlider.getValue();
            }
        });

        // Size slider
        JSlider sizeSlider = new JSlider(25, 125, 50);
        sizeSlider.setMajorTickSpacing(25);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setOrientation(SwingConstants.VERTICAL);

        TitledBorder sizeBorder = new TitledBorder("Choose size:");
        sizeBorder.setTitleJustification(TitledBorder.CENTER);
        sizeSlider.setBorder(sizeBorder);

        freqSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gf.side = sizeSlider.getValue();
            }
        });

        // Time slider
        JSlider timeSlider = new JSlider(15, 120, 30);
        timeSlider.setMajorTickSpacing(15);
        timeSlider.setPaintLabels(true);
        timeSlider.setPaintTicks(true);
        timeSlider.setSnapToTicks(true);
        timeSlider.setOrientation(SwingConstants.VERTICAL);

        TitledBorder timeBorder = new TitledBorder("Choose time:");
        timeBorder.setTitleJustification(TitledBorder.CENTER);
        timeSlider.setBorder(timeBorder);

        timeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gf.timeLimit = timeSlider.getValue();
            }
        });

        // Goal slider
        JSlider goalSlider = new JSlider(10, 100, 50);
        goalSlider.setMajorTickSpacing(15);
        goalSlider.setPaintLabels(true);
        goalSlider.setPaintTicks(true);
        goalSlider.setSnapToTicks(true);
        goalSlider.setOrientation(SwingConstants.VERTICAL);

        TitledBorder goalBorder = new TitledBorder("Choose goal:");
        goalBorder.setTitleJustification(TitledBorder.CENTER);
        goalSlider.setBorder(goalBorder);

        goalSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gf.goal = (float) goalSlider.getValue() / 100;
            }
        });

        // Play button
        JButton playButton = new JButton("Play");








        easyButton.addActionListener(e -> {
            freqSlider.setValue(40);
            sizeSlider.setValue(75);
            timeSlider.setValue(60);
            goalSlider.setValue(50);
        });
        mediumButton.addActionListener(e -> {

        });
        hardButton.addActionListener(e -> {

        });
        impossibleButton.addActionListener(e -> {

        });

        playButton.addActionListener(e -> {


            // jeśli nie ma ustawionego difficulty
            // dodać listenery do sliderów i nie będzie problemu
            dispose();
        });






        Container cp = getContentPane();


        JPanel diffButtons = new JPanel();
        diffButtons.setLayout(new GridLayout(1, 0));

        diffButtons.add(easyButton);
        diffButtons.add(mediumButton);
        diffButtons.add(hardButton);
        diffButtons.add(impossibleButton);



        TitledBorder chooseDiff = new TitledBorder("Choose difficulty:");
        chooseDiff.setTitleJustification(TitledBorder.CENTER);

        diffButtons.setBorder(chooseDiff);

        cp.setLayout(new BorderLayout());
        cp.add(diffButtons, BorderLayout.NORTH);






        // PANEL Z PIONOWYMI SUWACZKAMI
        JPanel sliders = new JPanel(new GridLayout(1, 0));
        sliders.add(freqSlider);
        sliders.add(sizeSlider);
        sliders.add(timeSlider);
        sliders.add(goalSlider);
        cp.add(sliders, BorderLayout.CENTER);
        cp.add(playButton, BorderLayout.SOUTH);


        pack();
    }
}