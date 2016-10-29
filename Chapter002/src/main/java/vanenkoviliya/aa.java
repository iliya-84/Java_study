package vanenkoviliya;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 05.10.2016
 **/
public class aa {

    /**
     * Вычисление факториала.
     * @param x первый аргумент
     * @return результат вычисления
     */
    public int calculate(int x) {
        int result = 1;
        for (int a=x;a>0;a--) {
            result = result*a;
        }
        return result;
    }
}

