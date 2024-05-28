
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    public class DoubleCalculator extends ACalculator<Double> {
    public DoubleCalculator(double state) {
        this.state = state;
    }

    protected void init() {
        state = 0.0;
    }

    public DoubleCalculator add(double value) {
        this.state += value;
        return this;
    }

    public DoubleCalculator subtract(double value) {
        state -= value;
        return this;
    }

    public DoubleCalculator multiply(double value) {
        state *= value;
        return this;
    }
}

class DoubleCalculatorTest {

    @Test
    void resultShouldReturnState() {
        DoubleCalculator calculator = new DoubleCalculator(10.0);

        Double result = calculator.result();

        assertEquals(10.0, result);
    }

    @Test
    void addShouldIncrementState() {
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        DoubleCalculator modifiedCalculator = calculator.add(3.5);

        assertEquals(8.5, modifiedCalculator.result());
    }

    @Test
    void subtractShouldDecrementState() {
        DoubleCalculator calculator = new DoubleCalculator(10.0);

        DoubleCalculator modifiedCalculator = calculator.subtract(2.5);

        assertEquals(7.5, modifiedCalculator.result());
    }

    @Test
    void multiplyShouldMultiplyState() {
        DoubleCalculator calculator = new DoubleCalculator(4.0);

        DoubleCalculator modifiedCalculator = calculator.multiply(2.5);

        assertEquals(10.0, modifiedCalculator.result());
    }
}

