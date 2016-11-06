package vanenkoviliya.checkstring;

import org.junit.Test;
import vanenkoviliya.factorial.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 06.11.2016
 **/
public class CheckstringTest
{
    @Test
    /**
     *Проверка метода поиска подстроки в строке.
     */
    public void whenOrigincontainssubShouldTrue() {
    Checkstring checkstring = new Checkstring();
    assertThat(checkstring.contains("мама мыла раму","мыла"), is(true));
    assertThat(checkstring.contains("мама мыла раму","папа"), is(false));
    }
}
