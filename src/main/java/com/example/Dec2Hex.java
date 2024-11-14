package com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Dec2Hex {
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

public static void main(String[] args) {
    if (args.length == 0) {
        logger.severe("Please provide a decimal number as an argument.");
        return;
    }
    try {
        int decimal = Integer.parseInt(args[0]);
        String hex = Integer.toHexString(decimal).toUpperCase();
        logger.info("The hexadecimal value is: " + hex);
    } catch (NumberFormatException e) {
        logger.severe("Invalid input. Please enter a valid integer.");
    }
}
}

