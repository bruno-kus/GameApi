package Utilities;

import Game.AbstractFrame;
import Game.AbstractPanel;

import java.lang.reflect.Constructor;

public class Utilities {
    public static AbstractPanel buildScreen(Class<? extends AbstractPanel> clazz, AbstractFrame frame) {
        try {
            Constructor<? extends AbstractPanel> constructor = clazz.getConstructor(AbstractFrame.class);
            return constructor.newInstance(frame);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





























}
