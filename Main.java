class Form{

    private String color;
    private static int counter = 0;
    public Form()
    {
        this.color = "white";
        counter++;
    }

    public Form(String color)
    {
        this.color=color;
        counter++;
    }

    public float GetArea()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "This form has the color " + color;
    }

    public static int getCounter()
    {
        return counter;
    }
}

class Triangle extends Form{
    private float height;
    private float base;

    public Triangle()
    {
        super();
        this.height=0;
        this.base=0;
    }

    public Triangle(float height, float base, String color)
    {
        super(color);
        this.height=height;
        this.base=base;
    }

    public float getArea()
    {
        return (base+height)/2;
    }

    public String toString()
    {
        return super.toString() + getArea();
    }

}

class Circle extends Form{

    private float radius;

    public Circle()
    {
        super();
        this.radius=0;
    }

    public Circle(float radius, String color)
    {
        super(color);
        this.radius=radius;
    }

    public float getArea()
    {
        return (float) (Math.PI * radius * radius);
    }

    public String toString()
    {
        return super.toString() + getArea();
    }
}

class Square extends Form{

    private float side;

    public Square()
    {
        super();
        this.side=0;
    }

    public Square(float side, String color)
    {
        super(color);
        this.side=side;
    }

    public float getArea()
    {
        return side * side;
    }

    public String toString()
    {
        return super.toString() + getArea();
    }
}

class StringRandomizer {
    java.util.Random rand = new java.util.Random();

    public String randomString(int n) {
        int countLetters = 'z' - 'a';
        char result[] = new char[n];

        for (int i = 0; i < n; i++) {
            result[i] = (char) ('a' + rand.nextInt(countLetters));
        }
        return new String(result);
    }

    public String randomString(int n, String alphabet) {
        int countLetters = alphabet.length();
        char result[] = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = alphabet.charAt(rand.nextInt(countLetters));
        }

        return new String(result);
    }
}

class PasswordMaker {
    private static final int MAGIC_NUMBER = 8;
    private static final String MAGIC_STRING = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";

    private String name;

    public PasswordMaker(String name) {
        this.name = name;
    }

    public String getPassword()
    {
        StringRandomizer randomizer = new StringRandomizer();

        String randomPart = randomizer.randomString(MAGIC_NUMBER);

        String alphabet = MAGIC_STRING.substring(5, 15);

        String alphabetPart = randomizer.randomString(10, alphabet);

        String nameLengthPart = String.valueOf(name.length());

        int randomNumber = randomizer.rand.nextInt(51);

        String password = randomPart + alphabetPart + nameLengthPart + randomNumber;

        return password;
    }
}

public class Main
{public static void main(String[] args)
{
    Triangle tri = new Triangle(1.1f,2.0f,"green");
    Circle c = new Circle(1.5f,"red");
    Square sq = new Square(1.2f,"blue");
    System.out.println("Triangle area = " + tri.getArea()+" details: " + tri);
    System.out.println("Circle area = " + c.getArea() + " details: " + c);
    System.out.println("Square area = " + sq.getArea() + " details: " + sq);
    System.out.println("Counter Value = " + Form.getCounter());
    PasswordMaker passwordMaker = new PasswordMaker("JohnDoe");
    String password = passwordMaker.getPassword();
    System.out.println("Generated Password: " + password);

}}