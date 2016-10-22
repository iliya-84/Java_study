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
        double maxlength = 0;
        for (double n : sides) {
            if (n > maxlength) maxlength = n;
           }
              return maxlength;
    }
}
