package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Dec2HexTest {

    private final Logger logger = Logger.getLogger(Dec2HexTest.class.getName());
    private ByteArrayOutputStream logContent;

    @BeforeEach
    public void setUp() {
        logContent = new ByteArrayOutputStream();
        Handler consoleHandler = new ConsoleHandler() {
            @Override
            public void publish(LogRecord logRecord) {
                try {
                    logContent.write((logRecord.getLevel() + ": " + logRecord.getMessage() + "\n").getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        if (consoleHandler.getFormatter() == null) {
            consoleHandler.setFormatter(new SimpleFormatter());
        }

        consoleHandler.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
    }

    @Test
    public void testValidInput() {
        Dec2Hex.main(new String[]{"255"});
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("INFO: The hexadecimal value is: FF"));
    }

    @Test
    public void testMissingInput() {
        Dec2Hex.main(new String[]{});
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("SEVERE: Please provide a decimal number as an argument."));
    }

    @Test
    public void testNonIntegerInput() {
        Dec2Hex.main(new String[]{"abc"});
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("SEVERE: Invalid input. Please enter a valid integer."));
    }

    @Test
    public void testZeroInput() {
        Dec2Hex.main(new String[]{"0"});
        String logOutput = logContent.toString();
        assertTrue(logOutput.contains("INFO: The hexadecimal value is: 0"));
    }
}
