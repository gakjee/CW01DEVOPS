package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dec2HexTest {
    private static final Logger logger = Logger.getLogger(Dec2Hex.class.getName());

    @Test
    public void testValidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setOutputStream(outputStream);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
        
        Dec2Hex.main(new String[]{"255"});
        
        String expectedOutput = "The hexadecimal value is: FF\n";
        assertTrue(outputStream.toString().contains(expectedOutput));
        
        logger.removeHandler(consoleHandler);
    }

    @Test
    public void testMissingInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setOutputStream(outputStream);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
        
        Dec2Hex.main(new String[]{});
        
        String expectedOutput = "Please provide a decimal number as an argument.\n";
        assertTrue(outputStream.toString().contains(expectedOutput));
        
        logger.removeHandler(consoleHandler);
    }

    @Test
    public void testNonIntegerInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setOutputStream(outputStream);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
        
        Dec2Hex.main(new String[]{"ABC"});
        
        String expectedOutput = "Invalid input. Please enter a valid integer.\n";
        assertTrue(outputStream.toString().contains(expectedOutput));
        
        logger.removeHandler(consoleHandler);
    }

    @Test
    public void testZeroInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setOutputStream(outputStream);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
        
        Dec2Hex.main(new String[]{"0"});
        
        String expectedOutput = "The hexadecimal value is: 0\n";
        assertTrue(outputStream.toString().contains(expectedOutput));
        
        logger.removeHandler(consoleHandler);
    }
}

