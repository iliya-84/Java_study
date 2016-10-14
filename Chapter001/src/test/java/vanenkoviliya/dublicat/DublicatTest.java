package vanenkoviliya.dublicat;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.10.2016
 **/
public class DublicatTest {

    @Test
    /**
     * Проверка удаления дубликатов из массива строк.  Сравнение полученного масива с правильным.
     */
    public void whenDeldublShouldUdalenie() {
        String[] values = {"aa","aa","bb","cc","cc","cc","bb","dd","ee","bb","ee","aa","aa"};
        String[] testvalues = {"aa","bb","cc","dd","ee", null, null, null, null, null, null, null, null};
        Dublicat dublicat = new Dublicat();
        dublicat.deldubl(values);
        assertArrayEquals(values,testvalues);
    }
}
