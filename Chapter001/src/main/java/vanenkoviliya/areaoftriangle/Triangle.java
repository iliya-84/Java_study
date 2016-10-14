package vanenkoviliya.areaoftriangle;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 1.10.2016
 **/
public class Triangle {
    double ab;
    double bc;
    double ac;
    /**
     * Вычисление длин строн треугольника
     * @param a первая точка
     * @param b вторая точка
     * @param c третья точка
     */
    public Triangle(Point a, Point b, Point c) {
         ab = a.distanceTo(b);
         bc = b.distanceTo(c);
         ac = a.distanceTo(c);
      }
    /** Вычисление площади треугольника по формуле Герона.
     *
     * @return площадь треугольника
     */
    public double area() {
        double p = (ab+bc+ac)/2; //Полупериметр
        if (ab + bc == ac || ab + ac == bc || ac + bc == ab) {
            throw new ArithmeticException("The triangle is impossible");
        }
        return Math.round(Math.sqrt(p*(p-ab)*(p-bc)*(p-ac))*100)/100;
    }
}
