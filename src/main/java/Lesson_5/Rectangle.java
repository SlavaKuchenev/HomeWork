package Lesson_5;

public class Rectangle implements AreaAndPerimeter {
    private String colorFill;
    private String colorOutline;
    private double area;
    private double perimeter;

    public Rectangle(String colorFill, String colorOutline, double height, double wide) {
        this.colorFill = colorFill;
        this.colorOutline = colorOutline;
        this.area = areaOfTheRectangle(height, wide);
        this.perimeter = perimeterOfTheRectangle(height, wide);
    }

    @Override
    public String toString() {
        return String.format("Площадь треугольника = %.2f, периметр треугольника = %.2f, цвет фона: %s, цвет границ: %s", area, perimeter, colorFill, colorOutline);
    }

}
