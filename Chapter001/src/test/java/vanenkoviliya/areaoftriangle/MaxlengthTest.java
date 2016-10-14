package vanenkoviliya.areaoftriangle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxlengthTest {
    @Test
    /**
     *Сравнение вычисленного значения максимальной стороны с ожидаемым
     */
    public void WhenMaxShouldMaxlength() {
        Point a = new Point(0,0);
        Point b = new Point(1,1);
        Point c = new Point(3,2);
        Triangle triangle =  new Triangle(a,b,c);
        Maxlength maxlength = new Maxlength();
        assertThat(maxlength.max(triangle.ab,triangle.bc,triangle.ac), is(3.61d));
    }
}