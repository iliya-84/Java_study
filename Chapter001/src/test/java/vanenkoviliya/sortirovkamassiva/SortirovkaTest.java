package vanenkoviliya.sortirovkamassiva;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author vanenkov_ia
 * @version 1
 * @since 05.10.2016
 **/
public class SortirovkaTest
{
    @Test
    /**
     *Проверка сортировки методом заданного массива от меньшего к большему.
     */
    public void whenSortShouldSortirovka() {
        int[] values = {9,-2,0,4};
        Sortirovka sortirovka = new Sortirovka();
        sortirovka.sort(values);
        assertThat(values[0], is(-2));
        assertThat(values[1], is(0));
        assertThat(values[2], is(4));
        assertThat(values[3], is(9));
    }
}

