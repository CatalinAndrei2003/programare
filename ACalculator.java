
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class ACalculator<T> {
    protected T state;

    public T result() {
        return state;
    }

    public ACalculator clear() {
        this.init();
        return this;
    }

    protected abstract void init();
}

class ACalculatorTest {

    @Test
    void resultShouldReturnState() {
        ACalculator<Integer> calculator = new MockCalculator<>(10);

        Integer result = calculator.result();

        assertEquals(10, result);
    }

    @Test
    void clearShouldResetState() {
        MockCalculator<Integer> calculator = new MockCalculator<>(10);

        ACalculator<Integer> clearedCalculator = calculator.clear();

        assertEquals(null, clearedCalculator.result());
    }

    private static class MockCalculator<T> extends ACalculator<T> {
        MockCalculator(T initialState) {
            this.state = initialState;
        }

        @Override
        protected void init() {

        }
    }
}

