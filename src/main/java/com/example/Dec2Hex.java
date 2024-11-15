package com.example;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;

public class Dec2Hex {

    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    static {
        // Set up logger only once using static initializer
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }

    // Method to add a custom handler
    public static void addHandler(Handler handler) {
        logger.addHandler(handler);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.severe("Please provide a decimal number as an argument.");
            return;
        }

        try {
            int decimalValue = Integer.parseInt(args[0]);
            String hexValue = Integer.toHexString(decimalValue).toUpperCase();
            logger.info("The hexadecimal value is: " + hexValue);
        } catch (NumberFormatException e) {
            logger.severe("Invalid input. Please enter a valid integer.");
        }
    }
}
