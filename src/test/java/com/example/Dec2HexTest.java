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
        streamHandler.flush();
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("The hexadecimal value is: FF"), "Valid input test failed.");
    }

    @Test
    public void testMissingInput() {
        Dec2Hex.main(new String[]{});
        streamHandler.flush();
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("Please provide a decimal number as an argument."), "Missing input test failed.");
    }

    @Test
    public void testNonIntegerInput() {
        Dec2Hex.main(new String[]{"abc"});
        streamHandler.flush();
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("Invalid input. Please enter a valid integer."), "Non-integer input test failed.");
    }

    @Test
    public void testZeroInput() {
        Dec2Hex.main(new String[]{"0"});
        streamHandler.flush();
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("The hexadecimal value is: 0"), "Zero input test failed.");
    }
}
