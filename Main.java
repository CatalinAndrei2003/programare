
class Form{

  private String color;
  public Form()
  {
      this.color = "white";
  }

  public Form(String color)
  {
      this.color=color;
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

public class Main
{public static void main(String[] args)
{
    Triangle tri = new Triangle(1.1f,2.0f,"green");
    Circle c = new Circle(1.5f,"red");
    Square sq = new Square(1.2f,"blue");
    System.out.println("Triangle area = " + tri.getArea()+" details: " + tri);
    System.out.println("Circle area = " + c.getArea() + " details: " + c);
    System.out.println("Square area = " + sq.getArea() + " details: " + sq);

}}


