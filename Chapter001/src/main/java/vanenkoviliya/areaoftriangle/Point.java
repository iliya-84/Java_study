package vanenkoviliya.areaoftriangle;

/**
 * @author vanenkov
 * @since 1.10.16.
 * @version 1
 * */
public class Point {
    public double x;
    public double y;
    /**
     *Присваивание переменным класса значения, переданные в конструктор.
     * @param x первый аргумент
     * @param y второй аргумент
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     *Вычисление расстояния между данной точкой и другой.
     * @param point первый аргумент
     * @return результат
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.y-this.y,2)+Math.pow(point.x-this.x,2));
    }
}
