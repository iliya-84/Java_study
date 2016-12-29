package vanenkoviliya.Tracker;
/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class StartUi {
    private Input input;
    private Tracker tracker;
    public  static boolean breakLoop = false; // Остановка основного цикла программы.

    public static void main(String[] args)  {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        StartUi startUi = new StartUi(input, tracker);
        startUi.init();
     }

    /**
     * Конструктор. Присваивает полям класса введенных значений input и tracker.
     * @param input ввод данных.
     **/
    StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Вывод приветствия. Выполнение метода в соответствии с выбором пользователя.
     */
    public void init()  {
        System.out.println("Программа учета заявок\nПозволяет хранить и редактировать заявки\nРазработал Ваненков Илья\nМосква 2016 год.");
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.showMenu();
            menu.select(input.ask("*Выберите действие: ", menu.getKeys()));
        } while (breakLoop == false);
  }
}


