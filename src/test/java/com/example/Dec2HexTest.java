import com.example.Dec2Hex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Dec2HexTest {

    @Test
    public void testValidInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"255"});

        String output = outputStream.toString();
        System.out.println("Test Valid Input Output: " + output);
        assertTrue(output.contains("The hexadecimal value is: FF"));

        System.setOut(originalOut);
    }

    @Test
    public void testMissingInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{});

        String output = outputStream.toString();
        System.out.println("Test Missing Input Output: " + output);
        assertTrue(output.contains("Please provide a decimal number as an argument"));

        System.setOut(originalOut);
    }

    @Test
    public void testNonIntegerInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"ABC"});

        String output = outputStream.toString();
        System.out.println("Test Non-Integer Input Output: " + output);
        assertTrue(output.contains("Invalid input. Please enter a valid integer"));

        System.setOut(originalOut);
    }

    @Test
    public void testZeroInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"0"});

        String output = outputStream.toString();
        System.out.println("Test Zero Input Output: " + output);
        assertTrue(output.contains("The hexadecimal value is: 0"));
	//
        System.setOut(originalOut);
    }
}

