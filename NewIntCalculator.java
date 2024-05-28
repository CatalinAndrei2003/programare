
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    public class NewIntCalculator extends ACalculator<Integer> {
    public NewIntCalculator(int state) {
        this.state = state;
    }

    protected void init() {
        state = 0;
    }

    public NewIntCalculator add(int value) {
        this.state += value;
        return this;
    }

    public NewIntCalculator subtract(int value) {
        state -= value;
        return this;
    }

    public NewIntCalculator multiply(int value) {
        state *= value;
        return this;
    }
}

class NewIntCalculatorTest {

    @Test
    void resultShouldReturnState() {
        NewIntCalculator calculator = new NewIntCalculator(10);

        Integer result = calculator.result();

        assertEquals(10, result);
    }

    @Test
    void addShouldIncrementState() {
        NewIntCalculator calculator = new NewIntCalculator(5);

        NewIntCalculator modifiedCalculator = calculator.add(3);

        assertEquals(8, modifiedCalculator.result());
    }

    @Test
    void subtractShouldDecrementState() {
        NewIntCalculator calculator = new NewIntCalculator(10);

        NewIntCalculator modifiedCalculator = calculator.subtract(2);

        assertEquals(8, modifiedCalculator.result());
    }

    @Test
    void multiplyShouldMultiplyState() {
        NewIntCalculator calculator = new NewIntCalculator(4);

        NewIntCalculator modifiedCalculator = calculator.multiply(3);

        assertEquals(12, modifiedCalculator.result());
    }
}