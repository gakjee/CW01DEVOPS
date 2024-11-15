package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.util.logging.*;

public class Dec2HexTest {

    private final Logger logger = Logger.getLogger(Dec2HexTest.class.getName());
    private ByteArrayOutputStream logContent;
    private StreamHandler streamHandler;

    @BeforeEach
    public void setUp() {
        logContent = new ByteArrayOutputStream();
        streamHandler = new StreamHandler(logContent, new SimpleFormatter());

        logger.setUseParentHandlers(false);
        logger.addHandler(streamHandler);
        streamHandler.setLevel(Level.ALL);
        logger.setLevel(Level.ALL);
    }

    @Test
    public void testValidInput() {
        Dec2Hex.main(new String[]{"255"});
        streamHandler.flush();  // Ensure all log output is written to logContent
        String logOutput = logContent.toString().replaceAll("\r?\n", "");
        assertTrue(logOutput.contains("INFO: The hexadecimal value is: FF"), "Valid input test failed.");
    }

    @Test
    public void testMissingInput() {
        Dec2Hex.main(new String[]{});
        streamHandler.flush();  // Ensure all log output is written to logContent
        String logOutput = logContent.toString().replaceAll("\r?\n", "");
        assertTrue(logOutput.contains("SEVERE: Please provide a decimal number as an argument."), "Missing input test failed.");
    }

    @Test
    public void testNonIntegerInput() {
        Dec2Hex.main(new String[]{"abc"});
        streamHandler.flush();  // Ensure all log output is written to logContent
        String logOutput = logContent.toString().replaceAll("\r?\n", "");
        assertTrue(logOutput.contains("SEVERE: Invalid input. Please enter a valid integer."), "Non-integer input test failed.");
    }

    @Test
    public void testZeroInput() {
        Dec2Hex.main(new String[]{"0"});
        streamHandler.flush();  // Ensure all log output is written to logContent
        String logOutput = logContent.toString().replaceAll("\r?\n", "");
        assertTrue(logOutput.contains("INFO: The hexadecimal value is: 0"), "Zero input test failed.");
    }
}
