/*  PROBLEMA 1

class IntCalculator {
    public int state;

    public IntCalculator(int initialState) {
        this.state = initialState;
    }

    public IntCalculator add(int number) {
        this.state += number;
        return this;
    }

    public IntCalculator subtract(int number) {
        this.state -= number;
        return this;
    }

    public IntCalculator multiply(int number) {
        this.state *= number;
        return this;
    }

    public IntCalculator divide(int number)
    {
        this.state /= number;
        return this;
    }

    public int result() {
        return this.state;
    }

    public void clear() {
        this.state = 0;
    }
}

class AdvancedCalculator extends IntCalculator {

    public AdvancedCalculator(int initialState) {
        super(initialState);
    }

    public AdvancedCalculator divide(int number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        this.state /= number;
        return this;
    }

    public AdvancedCalculator power(int exponent) {
        this.state = (int) Math.pow(this.state, exponent);
        return this;
    }

    public AdvancedCalculator nthRoot(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Root must be a positive integer!");
        }
        this.state = (int) Math.pow(this.state, 1.0 / n);
        return this;
    }
}

public class Main {
    public static void main(String[] args) {

        IntCalculator calculator = new IntCalculator(10);
        int resultA = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + resultA);

        AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);
        int resultB = advancedCalculator.add(5).subtract(3).multiply(2).divide(4).result();
        System.out.println("b) " + resultB);

        int resultC = advancedCalculator.power(2).result();
        System.out.println("c) " + resultC);

        int resultD = advancedCalculator.nthRoot(2).result();
        System.out.println("d) " + resultD);
    }
}
*/
//PROBLEMA 2

abstract class ACalculator <T> {
    protected T state;

    public T result() {
        return this.state;
    }

    public void clear() {
        this.state = null;
    }

    public abstract void init(T initialState);
}

class NewIntCalculator extends ACalculator<Integer> {

    public void init(Integer initialState) {
        this.state = initialState;
    }

    public NewIntCalculator add(Integer number) {
        this.state += number;
        return this;
    }

    public NewIntCalculator subtract(Integer number) {
        this.state -= number;
        return this;
    }

    public NewIntCalculator multiply(Integer number) {
        this.state *= number;
        return this;
    }
}

class DoubleCalculator extends ACalculator<Double> {

    public void init(Double initialState) {
        this.state = initialState;
    }

    public DoubleCalculator add(Double number) {
        this.state += number;
        return this;
    }

    public DoubleCalculator subtract(Double number) {
        this.state -= number;
        return this;
    }

    public DoubleCalculator multiply(Double number) {
        this.state *= number;
        return this;
    }
}

public class Main {
    public static void main(String[] args) {

        NewIntCalculator intCalculator = new NewIntCalculator();
        intCalculator.init(10);
        int resultInt = intCalculator.add(5).subtract(3).multiply(2).result();
        System.out.println("(10 + 5 - 3) * 2 = " + resultInt);

        DoubleCalculator doubleCalculator = new DoubleCalculator();
        doubleCalculator.init(10.0);
        double resultDouble = doubleCalculator.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("(10 + 5 - 3.3) * 2.2 = " + resultDouble);
    }
}


