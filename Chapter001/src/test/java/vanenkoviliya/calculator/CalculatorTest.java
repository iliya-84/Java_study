package vanenkoviliya.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * @author vanenkov
 * @since 1.10.16.
 * @version 1
 * */
public class CalculatorTest{

    @Test
    public void whenAddShouldSum() {
        Calculator calculator = new Calculator();
        calculator.add(2,2);
        final double result = calculator.result;
        assertThat(result, is(4d));
    }
    @Test
    public void whenSubstractShouldDifference() {
        Calculator calculator = new Calculator();
        calculator.substract(5,2);
        final double result = calculator.result;
        assertThat(result, is(3d));
    }
    @Test
    public void whenDivShouldQuotient() {
        Calculator calculator = new Calculator();
        calculator.div(8,2);
        final double result = calculator.result;
        assertThat(result, is(4d));
    }
    @Test
    public void whenultipleShouldProduct() {
        Calculator calculator = new Calculator();
        calculator.multiple(3,3);
        final double result = calculator.result;
        assertThat(result, is(9d));
    }
}
