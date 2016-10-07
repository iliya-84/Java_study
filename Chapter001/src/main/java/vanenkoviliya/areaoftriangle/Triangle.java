package vanenkoviliya.areaoftriangle;

/**
 * @author vanenkov
 * @since 2.10.16.
 * @version 1
 * */
public class Triangle {
    public Point a;
    public Point b;
    public Point c;
    double ab;
    double bc;
    double ac;
    /**
     *Присваивание переменным класса значения, переданные в конструктор.
     * @param a первый аргумент
     * @param b второй аргумент
     * @param c третий аргумент
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ab = a.distanceTo(b);
        bc = b.distanceTo(c);
        ac = a.distanceTo(c);
    }
    /**
     *Вычисление площади по формуле Герона и округление до сотых
     * @return результат
     */
    public double area() {
        double p = (ab+bc+ac)/2; // Полупериметр
        if (ab+bc==ac || ab+ac==bc || ac+bc==ab) {
            throw new ArithmeticException("The triangle is impossible");
        }
        return Math.round(Math.sqrt(p*(p-ab)*(p-bc)*(p-ac))*100.0)/100.0;
    }
}
