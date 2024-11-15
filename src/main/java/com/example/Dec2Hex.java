package com.example;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Dec2Hex {

    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String[] args) {
        // Set up logger
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);

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
