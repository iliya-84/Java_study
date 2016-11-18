package vanenkoviliya.Tracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class StartUi {
    static Tracker tracker = new Tracker();

    /**
     * Вывод приветствия. Выполнение метода в соответствии с выбором пользователя.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ConsoleInput consoleInput = new ConsoleInput();
        System.out.println("Программа учета заявок\nПозволяет хранить и редактировать заявки\nРазработал Ваненков Илья\nМосква 2016 год");
        reader.readLine();
        String menu;
        while (true) {
            System.out.println("\n*Ведите 1 для добавления заявки \n*Ведите 2 для редактирования заявки\n*Ведите 3 для удаления заявки\n*Ведите 4 для вывода списка заявок\n*Ведите 5 для вывода списка заявок с фильтром\n*Ведите 6 для выхода");
            menu = consoleInput.input();
            if (menu.equals("1")) tracker.add();
            else if (menu.equals("2")) tracker.edit();
            else if (menu.equals("3")) tracker.delete();
            else if (menu.equals("4")) tracker.getlist();
            else if (menu.equals("5")) getlistbyfiltr();
            else if (menu.equals("6")) break;
            else System.out.println("Неверный ввод");
        }
    }

    /**
     * Отображение списка заявок по фильтру.
     */
    static void getlistbyfiltr() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("*Для вывода списка по имени нажмите 1\n*Для вывода списка по описанию 2");
        String read = reader.readLine();
        System.out.println(read);
        if (read.equals("1")) {
            System.out.println("*Введите имя для поиска");
            String searchname = reader.readLine();
            for (int i = 0; i < tracker.applications.size(); i++) {
                if (tracker.applications.get(i).name.equals(searchname) == true) {
                    applicationprint(i);
                }
            }
        } else if (read.equals("2")) {
            System.out.println("*Введите описание для поиска");
            String searcdate = reader.readLine();
            for (int i = 0; i < tracker.applications.size(); i++) {
                if (tracker.applications.get(i).description.equals(searcdate) == true) {
                    applicationprint(i);
                }
            }
        } else System.out.println("*Неверный ввод");
    }

    /**
     * Вывод в консоль заявки по номеру.
     * @param i массив для сортировки
     */
    static void applicationprint(int i) {
        System.out.println("№" + (i + 1) + " Имя:" + tracker.applications.get(i).name + " Дата создания: " + tracker.applications.get(i).date + "  Описание: " + tracker.applications.get(i).description);
        for (int j = 0; j < tracker.applications.get(i).comments.size(); j++) {
            if (tracker.applications.get(i).comments.get(j).equals("") == false)
                System.out.println("Комментарий " + (j + 1) + ": " + tracker.applications.get(i).comments.get(j));
        }
    }
}
