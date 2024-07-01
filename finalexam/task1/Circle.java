package finalexam.task1;

public class Circle implements Drawable {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter and Setter
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void Draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
