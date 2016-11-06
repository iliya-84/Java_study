package vanenkoviliya.arrayconnection;

import org.junit.Test;
import vanenkoviliya.arraysorting.Arraysorting;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 02.11.2016
 **/
public class ArrayconnectionTest {
    @Test
    /**
     *Проверка метода своединения двух отсортированных массивов и сортировка полученного массива. Сравнение полученного масива с верно отсортированным массивом.
     */
    public void whenSumShouldSumarray() {
        int[] a = {1, 3, 5, 6, 7};
        int[] b = {2, 4, 6, 7, 8};
        int[] testarray = {1, 2, 3, 4, 5, 6, 7, 8, 0, 0};
        Arrayconnection arrayconnection = new Arrayconnection();
        assertArrayEquals(arrayconnection.sum(a, b), testarray);
    }
}
