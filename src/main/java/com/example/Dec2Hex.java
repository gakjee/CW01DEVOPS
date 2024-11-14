package com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Dec2Hex {
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.info("Please provide a decimal number as an argument.");
            return;
        }

        try {
            int decimal = Integer.parseInt(args[0]);
            String hexValue = Integer.toHexString(decimal).toUpperCase();
            logger.info("The hexadecimal value is: " + hexValue);
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Invalid input. Please enter a valid integer.", e);
        }
    }
}

