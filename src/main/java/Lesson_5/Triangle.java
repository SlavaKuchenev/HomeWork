package Lesson_5;

public class Triangle extends Figure {
    private double side1;
    private double side2;
    private double side3;


    public Triangle(String colorFill, String colorOutline, double side1, double side2, double side3) {
        super(colorFill, colorOutline);
        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side3 + side2) > side1) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            System.out.println("Треугольника не существует");
            this.side1 = 0;
            this.side2 = 0;
            this.side3 = 0;
        }
    }

    @Override
    public double area() {
        double Perimeter = (side1 + side2 + side3);
        return Math.sqrt(Perimeter * (Perimeter - side1) * (Perimeter - side2) * (Perimeter - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
            return String.format("Площадь треугольника = %.2f, периметр треугольника = %.2f,", area(), perimeter()) + super.toString();
        }
}
