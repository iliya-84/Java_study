package vanenkoviliya.areaoftriangle;

/**
 * @author vanenkov
 * @since 3.10.16.
 * @version 1
 * */
public class Maxlength
{
    /**
     *Вычисление наибольшей длины стороны треуголольника
     * @param sides переменный аргумент
     * @return результат, длина наибольшей стороны
     */
    public double max(double...sides) {
        double Maxlength = 0;
        for (double n : sides) {
            if (n > Maxlength) Maxlength = n;
           }
            return Math.round(Maxlength * 100.0) / 100.0;
    }
}
