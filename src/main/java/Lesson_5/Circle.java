package Lesson_5;

public class Circle extends Figure {
    private double radius;

    public Circle(String colorFill, String colorOutline, double radius) {
        super(colorFill, colorOutline);
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("Площадь круга = %.2f, периметр круга = %.2f,", area(), perimeter()) + super.toString();
    }
}
