package vanenkoviliya.areaoftriangle;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * @author vanenkov
 * @since 1.10.16.
 * @version 1
 * */
public class TriangleTest {
    @Test
    public void whenAddShouldSquare() {
        Point a = new Point(0,0);
        Point b = new Point(1,4);
        Point c = new Point(3,2);
        Triangle triangle =  new Triangle(a,b,c);
        assertThat(triangle.area(), is(5d));
    }
}