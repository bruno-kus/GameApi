package Utilities;

import Game.AbstractFrame;
import Game.AbstractPanel;

import java.lang.reflect.Constructor;

public class Utilities {
    public static <T> T createObjectFromClass(Class<T> clazz, Object... constructorArgs) {
        try {
            // Get the appropriate constructor of the class
            Constructor<T> constructor = clazz.getDeclaredConstructor(getConstructorParameterTypes(constructorArgs));

            // Create an instance of the class using the constructor and provided arguments
            T obj = constructor.newInstance(constructorArgs);

            // Perform operations on the created object
            // ...

            // Example: Print the class name
            System.out.println("Created object of class: " + clazz.getSimpleName());

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // or throw an exception based on your error handling strategy
        }
    }
    private static Class<?>[] getConstructorParameterTypes(Object... constructorArgs) { // sick!
        Class<?>[] parameterTypes = new Class<?>[constructorArgs.length];
        for (int i = 0; i < constructorArgs.length; i++) {
            parameterTypes[i] = constructorArgs[i].getClass();
        }
        return parameterTypes;
    }
    public static AbstractPanel buildScreen(Class<? extends AbstractPanel> clazz, AbstractFrame frame) {
        try {
            Constructor<? extends AbstractPanel> constructor = clazz.getDeclaredConstructor(AbstractFrame.class);
            return constructor.newInstance(frame);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





























}
