package vanenkoviliya.Tracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class StartUi {
    private Input input;
    private Tracker tracker = new Tracker();
    public static void main(String[] args)  {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUi startUi = new StartUi(input, tracker);
        startUi.init();
     }
    /**
     * Вывод приветствия. Выполнение метода в соответствии с выбором пользователя.
     */
    public void init()  {
        System.out.println("Программа учета заявок\nПозволяет хранить и редактировать заявки\nРазработал Ваненков Илья\nМосква 2016 год");
        Menu menu = new Menu(input, tracker);
        boolean breakLoop = false;
        while (breakLoop == false) {
            breakLoop = menu.choise(input.ask("\n*Ведите 1 для добавления заявки \n*Ведите 2 для редактирования заявки\n*Ведите 3 для удаления заявки\n*Ведите 4 для вывода списка заявок\n*Ведите 5 для вывода списка заявок с фильтром\n*Ведите 6 для выхода"));
        }
    }
    /**
     * Конструктор. Присваивает полям класса введенных значений input и tracker.
     * @param input ввод данных.
     * @param tracker трекер с заявками.
     **/
      StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

}


