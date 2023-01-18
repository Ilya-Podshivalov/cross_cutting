package MathExample;

import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class MathExampleTest {

    @Test
    public void calculate() throws UnparsableExpressionException, UnknownFunctionException {
        MathExample mathExample = new MathExample();
        Double expected = 147.0;
        assertEquals(expected, mathExample.Calculate("2 + 5 + 8 * (37 - 2) / 2"));
    }
}