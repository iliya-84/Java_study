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
     * @param triangle первый аргумент
     * @return результат
     */
    public double max(Triangle triangle){
        double Maxlength;
        Maxlength=triangle.ab;
        if (triangle.bc>Maxlength) Maxlength=triangle.bc;
        if (triangle.ac>Maxlength) Maxlength=triangle.ac;
        return Math.round(Maxlength*100.0)/100.0;
    }
}
