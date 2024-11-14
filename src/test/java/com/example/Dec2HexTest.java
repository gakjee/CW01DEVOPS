package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dec2HexTest {
    @Test
    public void testValidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"255"});
        String expectedOutput = "The hexadecimal value is: FF\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testMissingInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{});
        String expectedOutput = "Please provide a decimal number as an argument.\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testNonIntegerInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"ABC"});
        String expectedOutput = "Invalid input. Please enter a valid integer.\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    public void testZeroInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"0"});
        String expectedOutput = "The hexadecimal value is: 0\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }
}

