package vanenkoviliya.Tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author ИЛЬЯ
 * @version 1
 * @since 26.11.2016
 */
public class TrackerTest {

    Tracker tracker = new Tracker();

    @Test
    /**
     *Проверка метода добавления заявки.
     */
    public void whenAddShouldAddApp() throws Exception {
        tracker.add();
        tracker.add();
        tracker.add();
        assertThat(tracker.quantity, is(3));
    }
    @Test
    /**
     *Проверка метода удаления заявки.
     */
    public void whenDeleteShouldDelApp() throws Exception {
        tracker.add();
        tracker.add();
        tracker.add();
        tracker.delete(0);
        assertThat(tracker.quantity, is(2));
    }
    @Test
    /**
     *Проверка метода редактирования заявки.
     */
    public void whenEditShouldEditApp() throws Exception {
        tracker.add();
        tracker.applications[0].name = "name";
        tracker.applications[0].description = "description";
        tracker.edit(0,"1","newname");
        tracker.edit(0,"2","newdescription");
        tracker.edit(0,"3","newcomment");
        assertThat(tracker.applications[0].name.equals("newname"), is(true));
        assertThat(tracker.applications[0].description.equals("newdescription"), is(true));
        assertThat(tracker.applications[0].comments[0].equals("newcomment"), is(true));
    }
}

