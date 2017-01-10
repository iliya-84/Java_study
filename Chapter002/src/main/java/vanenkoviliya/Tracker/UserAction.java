package vanenkoviliya.Tracker;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 21.12.2016
 **/
public interface UserAction {
    /**
     * Ключ действия.
     * @return ключ.
     */
    int key();

    /**
     * Действие, выбранное пользователем.
     * @param input ввод данных.
     * @param tracker трекер с заявками.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Сообщает, что делает данный метод
     * @return описание метода.
     */
    String info();
}
