package vanenkoviliya.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author vanenkov_ia
 * @version 1
 * @since 05.10.2016
 **/
public class FactorialTest {
    @Test
    /**
     *Сравнение вычисленного значения факториала 5! с ожидаемым
     */
    public void whenCalculateShouldFactorial() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calculate(5), is(120));
    }
}

