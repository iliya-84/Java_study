package vanenkoviliya.povorotmassiva;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 06.10.2016
 **/
public class PovorotTest
{
    @Test
    /**
     *Проверка поворота массива на 90 градусов.
     */
    public void whenSortShouldSortirovka() {
        int[][] values = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Povorot povorot = new Povorot();
        povorot.pov(values);
        assertThat(values[0][0], is(7));
        assertThat(values[0][1], is(4));
        assertThat(values[0][2], is(1));
        assertThat(values[1][0], is(8));
        assertThat(values[1][1], is(5));
        assertThat(values[1][2], is(2));
        assertThat(values[2][0], is(9));
        assertThat(values[2][1], is(6));
        assertThat(values[2][2], is(3));
    }
}

