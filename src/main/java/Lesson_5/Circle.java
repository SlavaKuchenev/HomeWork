package Lesson_5;

public class Circle implements AreaAndPerimeter {
    private String colorFill;
    private String colorOutline;
    private double area;
    private double perimeter;

    public Circle(String colorFill, String colorOutline, double radius) {
        this.colorFill = colorFill;
        this.colorOutline = colorOutline;
        this.area = areaOfTheCircle(radius);
        this.perimeter = perimeterOfTheCircle(radius);
    }

    @Override
    public String toString() {
        return String.format("Площадь треугольника = %.2f, периметр треугольника = %.2f, цвет фона: %s, цвет границ: %s", area, perimeter, colorFill, colorOutline);
    }
}
