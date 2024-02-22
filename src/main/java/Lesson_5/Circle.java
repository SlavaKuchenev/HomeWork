package Lesson_5;

public class Circle implements AreaAndPerimeter {
    private String colorFill;
    private String colorOutline;
    private double radius;
    private double area;
    private double perimeter;

    public Circle(String colorFill, String colorOutline, double radius) {
        this.colorFill = colorFill;
        this.colorOutline = colorOutline;
        this.radius = radius;
        this.area = AreaOfTheCircle(radius);
        this.perimeter = PerimeterOfTheCircle(radius);
    }

    @Override
    public void Info() {
        String str = String.format("Площадь круга = %.2f, периметр круга = %.2f, цвет фона: %s, цвет границ: %s", area, perimeter, colorFill, colorOutline);
        System.out.println(str);
    }
}
