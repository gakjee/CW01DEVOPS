package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.util.logging.*;

public class Dec2HexTest {

    private final Logger logger = Logger.getLogger(Dec2HexTest.class.getName());
    private ByteArrayOutputStream logContent;

    @BeforeEach
    public void setUp() {
        logContent = new ByteArrayOutputStream();
        StreamHandler streamHandler = new StreamHandler(logContent, new SimpleFormatter());

        logger.setUseParentHandlers(false);
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            logger.removeHandler(handler);
        }

        logger.addHandler(streamHandler);
        streamHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
    }

    @Test
    public void testValidInput() {
        Dec2Hex.main(new String[]{"255"});
        String logOutput = logContent.toString();
        logger.log(Level.INFO, "Log Output (Valid Input Test): {0}", logOutput);
        assertTrue(logOutput.contains("INFO: The hexadecimal value is: FF"), "Valid input test failed.");
    }

    @Test
    public void testMissingInput() {
        Dec2Hex.main(new String[]{});
        String logOutput = logContent.toString();
        logger.log(Level.INFO, "Log Output (Missing Input Test): {0}", logOutput);
        assertTrue(logOutput.contains("SEVERE: Please provide a decimal number as an argument."), "Missing input test failed.");
    }

    @Test
    public void testNonIntegerInput() {
        Dec2Hex.main(new String[]{"abc"});
        String logOutput = logContent.toString();
        logger.log(Level.INFO, "Log Output (Non-Integer Input Test): {0}", logOutput);
        assertTrue(logOutput.contains("SEVERE: Invalid input. Please enter a valid integer."), "Non-integer input test failed.");
    }

    @Test
    public void testZeroInput() {
        Dec2Hex.main(new String[]{"0"});
        String logOutput = logContent.toString();
        logger.log(Level.INFO, "Log Output (Zero Input Test): {0}", logOutput);
        assertTrue(logOutput.contains("INFO: The hexadecimal value is: 0"), "Zero input test failed.");
    }
}
