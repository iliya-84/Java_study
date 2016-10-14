package vanenkoviliya.arraysorting;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author vanenkov_ia
 * @version 1
 * @since 05.10.2016
 **/
public class SortingTest
{
    @Test
    /**
     *Проверка метода сортировки массива. Сравнение полученного масива с верно отсортированным массивом.
     */
    public void whenSortingShouldArraysorting() {
        int[] values = {9,-2,0,-5,4};
        int[] testvalues = {-5,-2,0,4,9};
        Arraysorting arraysorting = new Arraysorting();
        arraysorting.sorting(values);
        assertArrayEquals(values,testvalues);
    }
}
