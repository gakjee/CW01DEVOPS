//imports 
import com.example.Dec2Hex;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Dec2HexTest {

    private final Logger logger = Logger.getLogger(Dec2Hex.class.getName());
    private ByteArrayOutputStream logContent;

    @BeforeEach
    public void setUp() {
        logContent = new ByteArrayOutputStream();
        Handler consoleHandler = new ConsoleHandler() {
            @Override
            public void publish(LogRecord record) {
                if (getFormatter() == null) {
                    setFormatter(new SimpleFormatter());
                }
                try {
                    logContent.write((record.getLevel() + ": " + record.getMessage() + "\n").getBytes());
                } catch (Exception ignored) {}
            }
        };
        consoleHandler.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);
    }

    @Test
    public void testValidInput() {
        Dec2Hex.main(new String[]{"255"});

        String expectedOutput = "INFO: The hexadecimal value is: FF";
        assertTrue(logContent.toString().contains(expectedOutput));
    }

    @Test
    public void testMissingInput() {
        Dec2Hex.main(new String[]{});

        String expectedOutput = "SEVERE: Please provide a decimal number as an argument.";
        assertTrue(logContent.toString().contains(expectedOutput));
    }

    @Test
    public void testNonIntegerInput() {
        Dec2Hex.main(new String[]{"ABC"});

        String expectedOutput = "SEVERE: Invalid input. Please enter a valid integer.";
        assertTrue(logContent.toString().contains(expectedOutput));
    }

    @Test
    public void testZeroInput() {
        Dec2Hex.main(new String[]{"0"});

        String expectedOutput = "INFO: The hexadecimal value is: 0";
        assertTrue(logContent.toString().contains(expectedOutput));
    }
}

