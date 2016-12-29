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

   @Test
    public void whenAddSetNameOfApplication()   {
        String[] myAnswers = new String[]{"1","testName","testDescription","testComment"};
        Tracker testTracker = new Tracker();
        Input input = new StubInput(myAnswers);
        StartUi testStartUi = new StartUi(input, testTracker);
        testStartUi.init();
        assertThat(testTracker.applications[0].name, is("testName"));
    }
   @Test
    public void whenEditChangeNameOfApplication()   {
        String[] myAnswers1 = new String[]{"1","testName1","testDescription1","testComment1"};
        Tracker testTracker = new Tracker();
        Input input1 = new StubInput(myAnswers1);
        StartUi testStartUi1 = new StartUi(input1, testTracker);
        testStartUi1.init();
        String[] myAnswers2 = new String[]{"2",testTracker.applications[0].getId(),"newName","newDescription"};
        Input input2 = new StubInput(myAnswers2);
        StartUi testStartUi2 = new StartUi(input2, testTracker);
        testStartUi2.init();
        assertThat(testTracker.applications[0].name, is("newName"));
    }
   @Test
    public void whenDeleteDisappearOfApplication()   {
       String[] myAnswers1 = new String[]{"1","testName1","testDescription1","testComment1"};
       Tracker testTracker = new Tracker();
       Input input1 = new StubInput(myAnswers1);
       StartUi testStartUi1 = new StartUi(input1, testTracker);
       testStartUi1.init();
       String newid = testTracker.applications[0].id;
       String[] myAnswers2 = new String[]{"3",testTracker.applications[0].id};
       Input input2 = new StubInput(myAnswers2);
       StartUi testStartUi2 = new StartUi(input2, testTracker);
       testStartUi2.init();
       assertThat(testTracker.getdById(newid), is(-1));
    }
}
