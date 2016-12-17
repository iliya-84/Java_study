package vanenkoviliya.Tracker;

import org.junit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 12.12.2016
 */
public class UITest {

    Tracker testTracker = new Tracker();

    @Test
    public void whenAddSetNameOfApplication()  throws Exception  {
        String[] myAnswers = new String[]{"1","testName","testDescription","testComment"};
        Input input = new StubInput(myAnswers);
        StartUi testStartUi = new StartUi(input, testTracker);
        testStartUi.init();
        assertThat(testTracker.applications[0].name, is("testName"));
    }
    @Test
    public void whenEditChangeNameOfApplication()  throws Exception  {
        String[] myAnswers = new String[]{"1","testName1","testDescription1","testComment1"};
        Input input = new StubInput(myAnswers);
        StartUi testStartUi = new StartUi(input, testTracker);
        testStartUi.init();
        String[] myAnswers1 = new String[]{"2",testTracker.applications[0].id,"newName","newDescription"};
        Input input1 = new StubInput(myAnswers1);
        StartUi testStartUi1 = new StartUi(input1, testTracker);
        testStartUi1.init();
        assertThat(testTracker.applications[0].name, is("newName"));
    }
   @Test
    public void whenDeleteChangeNameOfApplication()  throws Exception  {
       String[] myAnswers = new String[]{"1","testName1","testDescription1","testComment1"};
       Input input = new StubInput(myAnswers);
       StartUi testStartUi = new StartUi(input, testTracker);
       testStartUi.init();
       String[] myAnswers1 = new String[]{"3",testTracker.applications[0].id};
       Input input1 = new StubInput(myAnswers1);
       StartUi testStartUi1 = new StartUi(input1, testTracker);
       testStartUi1.init();
       assertThat(testTracker.quantity, is(0));
    }
}
