package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.util.logging.*;

public class Dec2HexTest {

    private ByteArrayOutputStream logContent;
    private StreamHandler streamHandler;

    @BeforeEach
    public void setUp() {
        logContent = new ByteArrayOutputStream();
        streamHandler = new StreamHandler(logContent, new SimpleFormatter());

        
        Dec2Hex.addHandler(streamHandler);
        streamHandler.setLevel(Level.ALL);
    }

    @Test
    public void testValidInput() {
        Dec2Hex.main(new String[]{"255"});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("The hexadecimal value is: FF"), "Valid input test failed.");
    }

    @Test
    public void testMissingInput() {
        Dec2Hex.main(new String[]{});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("Please provide a decimal number as an argument."), "Missing input test failed.");
    }

    @Test
    public void testNonIntegerInput() {
        Dec2Hex.main(new String[]{"abc"});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("Invalid input. Please enter a valid integer."), "Non-integer input test failed.");
    }

    @Test
    public void testZeroInput() {
        Dec2Hex.main(new String[]{"0"});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("The hexadecimal value is: 0"), "Zero input test failed.");
    }

    @Test
    public void testNegativeInput() {
        Dec2Hex.main(new String[]{"-10"});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("The hexadecimal value is: FFFFFFF6"), "Negative input test failed.");
    }

    @Test
    public void testMaxIntegerInput() {
        Dec2Hex.main(new String[]{String.valueOf(Integer.MAX_VALUE)});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("The hexadecimal value is: 7FFFFFFF"), "Max integer input test failed.");
    }

    @Test
    public void testMinIntegerInput() {
        Dec2Hex.main(new String[]{String.valueOf(Integer.MIN_VALUE)});
        streamHandler.flush();
        String logOutput = logContent.toString().trim();
        assertTrue(logOutput.contains("The hexadecimal value is: 80000000"), "Min integer input test failed.");
    }
}
