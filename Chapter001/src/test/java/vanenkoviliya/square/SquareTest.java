package vanenkoviliya.square;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author vanenkov
 * @since 4.10.16.
 * @version 1
 **/
public class SquareTest {
    @Test
    /**
     *Сравнение вычисленных значений y с ожидаемыми
     */
    public void whenShowShouldSquare() {
        Square square = new Square(2,4,8);
        assertThat(square.calculate(0), is(8f));
        assertThat(square.calculate(1), is(14f));
        assertThat(square.calculate(2), is(24f));
        assertThat(square.calculate(3), is(38f));
    }
}
