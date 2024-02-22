package Lesson_5;

public interface AreaAndPerimeter {
    default double AreaOfTheTriangle(double side1, double side2, double side3) {
        double Perimeter = (side1 + side2 + side3);
        return Math.sqrt(Perimeter * (Perimeter - side1) * (Perimeter - side2) * (Perimeter - side3));
    }

    default double AreaOfTheCircle(double radius) {
        return radius * radius * Math.PI;
    }

    default double AreaOfTheRectangle(double height, double wide) {
        return height * wide;
    }

    default double PerimeterOfTheTriangle(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    default double PerimeterOfTheCircle(double radius) {
        return 2 * radius * Math.PI;
    }

    default double PerimeterOfTheRectangle(double height, double wide) {
        return (height + wide) * 2;
    }

    public void Info();
}
