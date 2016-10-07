package vanenkoviliya.dublicat;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.10.2016
 **/
public class DublicatTest {

    @Test
    /**
     *Проверка удаления дубликатов из массива строк.
     */
    public void whenSortShouldSortirovka() {
        String[] values = {"aa","aa","bb","cc","cc","bb","dd","ee","bb","ee"};
        Dublicat dublicat = new Dublicat();
        dublicat.udalenie(values);
        assertThat(values[0], is("aa"));
        assertThat(values[1], is(""));
        assertThat(values[2], is("bb"));
        assertThat(values[3], is("cc"));
        assertThat(values[4], is(""));
        assertThat(values[5], is(""));
        assertThat(values[6], is("dd"));
        assertThat(values[7], is("ee"));
        assertThat(values[8], is(""));
        assertThat(values[9], is(""));
    }
}
