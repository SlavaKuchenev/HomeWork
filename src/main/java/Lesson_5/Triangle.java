package Lesson_5;

public class Triangle implements AreaAndPerimeter {
    private String colorFill;
    private String colorOutline;
    private double side1;
    private double side2;
    private double side3;
    private double area;
    private double perimeter;

    public Triangle(String colorFill, String colorOutline, double side1, double side2, double side3) {
        this.colorFill = colorFill;
        this.colorOutline = colorOutline;
        this.side1 = side1;
        this.side2 = side3;
        this.side3 = side3;

        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side3 + side2) > side1) {
            this.area = AreaOfTheTriangle(side1, side2, side3);
            this.perimeter = PerimeterOfTheTriangle(side1, side2, side3);
        } else {
            System.out.println("Треугольника не существует");
            this.area = 0;
        }
    }

    @Override
    public void Info() {
        if (area == 0) {
            System.out.println("Треугольника не существует");
        } else {
            String str = String.format("Площадь треугольника = %.2f, периметр треугольника = %.2f, цвет фона: %s, цвет границ: %s", area, perimeter, colorFill, colorOutline);
            System.out.println(str);
        }
    }


}
