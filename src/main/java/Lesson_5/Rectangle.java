package Lesson_5;

public class Rectangle extends Figure {

    private double height;
    private double wide;


    public Rectangle(String colorFill, String colorOutline, double height, double wide) {
        super(colorFill, colorOutline);
        this.height = height;
        this.wide = wide;
    }

    @Override
    public double area() {
        return height * wide;
    }

    @Override
    public double perimeter() {
        return (height + wide) * 2;
    }

    @Override
    public String toString() {
        return String.format("Площадь прямоугольника = %.2f, периметр прямоугольника = %.2f,", area(), perimeter()) + super.toString();
    }

}
