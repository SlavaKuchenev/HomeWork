package Lesson_5;

public abstract class  Figure implements AreaFigure , PerimetrFigure {
    private String colorFill;
    private String colorOutline;

    public Figure(String colorFill, String colorOutline) {
        this.colorFill = colorFill;
        this.colorOutline = colorOutline;
    }

    @Override
    public String toString() {
        return String.format(" цвет фона: %s, цвет границ: %s", colorFill, colorOutline);
    }
}
