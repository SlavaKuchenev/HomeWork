package Lesson_5;

public class Triangle implements AreaAndPerimeter {
    private String colorFill;
    private String colorOutline;
    private double area;
    private double perimeter;

    public Triangle(String colorFill, String colorOutline, double side1, double side2, double side3) {
        this.colorFill = colorFill;
        this.colorOutline = colorOutline;

        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side3 + side2) > side1) {
            this.area = areaOfTheTriangle(side1, side2, side3);
            this.perimeter = perimeterOfTheTriangle(side1, side2, side3);
        } else {
            System.out.println("Треугольника не существует");
            this.area = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Площадь треугольника = %.2f, периметр треугольника = %.2f, цвет фона: %s, цвет границ: %s", area, perimeter, colorFill, colorOutline);
    }
}
