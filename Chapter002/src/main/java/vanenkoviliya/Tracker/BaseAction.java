package vanenkoviliya.Tracker;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 09.01.2017
 **/
abstract class BaseAction implements UserAction {
    String name;
      BaseAction (String name) {
          this.name = name;
      }
    abstract public int key();
    abstract public void execute(Input input, Tracker tracker);
    /**
     * Сообщает, что делает данный метод
     * @return описание метода.
     */
    public String info() {
            return String.format("%s. %s", this.key(), name);

    }
}
