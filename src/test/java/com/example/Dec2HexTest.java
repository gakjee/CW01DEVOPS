
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

        String expectedOutput = "The hexadecimal value is: FF\n";
        assertTrue(outputStream.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }

    @Test
    public void testMissingInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{});

        String expectedOutput = "Please provide a decimal number as an argument>
        assertTrue(outputStream.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }

    @Test
    public void testNonIntegerInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"ABC"});

        String expectedOutput = "Invalid input. Please enter a valid integer.\n>
        assertTrue(outputStream.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }

    @Test
    public void testZeroInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Dec2Hex.main(new String[]{"0"});

        String expectedOutput = "The hexadecimal value is: 0\n";
        assertTrue(outputStream.toString().contains(expectedOutput));

        System.setOut(originalOut);
    }
}



