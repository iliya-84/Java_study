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
            if (menu.equals("1")) {
                tracker.add();
                System.out.println("*Ведите имя:");
                tracker.applications[(tracker.quantity) - 1].name = reader.readLine();
                System.out.println("*Ведите описание:");
                tracker.applications[(tracker.quantity) - 1].description = reader.readLine();
                System.out.println("*Ведите комментарий:");
                String comment = reader.readLine();
                if (comment.equals("") == false) {
                tracker.applications[(tracker.quantity) - 1].comments[0] = comment;
                tracker.applications[(tracker.quantity) - 1].quantityofcomments++;
            }
            }

               else if (menu.equals("2")) {
                System.out.println("*Выберите номер заявки для редактирования:");
                int number;
                String change;
                String value;
                try{
                number = Integer.parseInt(reader.readLine()) - 1;
                applicationprint(number);

                System.out.println("*Для изменения имени нажмите 1 \n*Для изменения описания нажмите 2\n*Для добавления комментария нажмите 3");
                change = reader.readLine();
                if (change.equals("1")) {
                    System.out.println("*Введите имя:");
                    value = reader.readLine();
                } else if (change.equals("2")) {
                    System.out.println("*Введите описание:");
                    value = reader.readLine();
                } else if (change.equals("3")) {
                    System.out.println("*Введите комментарий");
                    value = reader.readLine();
                } else {
                    System.out.println("*Неверный ввод");
                    value = null;
                }
            if (change.equals(null)==false) tracker.edit(number, change, value);

            } catch (NumberFormatException e) {
                System.out.println("*Неверный ввод");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("*Заявка не существует");
            }
        }
            else if (menu.equals("3")) {
                System.out.println("*Выберите номер заявки для удаления:");
                try {
                tracker.delete(Integer.parseInt(reader.readLine()) - 1);
                      }
                catch (NumberFormatException e) {
                System.out.println("*Неверный ввод");
            }
                catch (IndexOutOfBoundsException e) {
                System.out.println("*Заявка не существует");
            }
           }

            else if (menu.equals("4")) getlist();
            else if (menu.equals("5")) getlistbyfiltr();
            else if (menu.equals("6")) break;
            else System.out.println("Неверный ввод");
        }
    }

    /**
     * Отображение списка всех заявок.
     */
    static void getlist() {
        for(int i=0;i<tracker.quantity;i++){
            applicationprint(i);
        }
    }
    /**
     * Отображение списка заявок по фильтру. Поиск происходит по содержанию подстроки в строке.
     */
   static void getlistbyfiltr() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("*Для вывода списка по имени нажмите 1\n*Для вывода списка по описанию 2");
        String read = reader.readLine();
        System.out.println(read);
        if (read.equals("1")) {
            System.out.println("*Введите имя для поиска");
            String searchname = reader.readLine();
            for (int i = 0; i < tracker.quantity; i++) {
                if (containssubstring(tracker.applications[i].name, searchname) == true) applicationprint(i);
            }
        }
        else if (read.equals("2")) {
            System.out.println("*Введите описание для поиска");
            String searchdate = reader.readLine();
            for (int i = 0; i < tracker.quantity; i++) {
                if (containssubstring(tracker.applications[i].name, searchdate)== true) applicationprint(i);
                }
            }
         else System.out.println("*Неверный ввод");
    }

    /**
     * Вывод в консоль заявки по номеру.
     * @param i массив для сортировки
     */
    static void applicationprint(int i) {
        System.out.println("№" + (i + 1) + " Имя:" + tracker.applications[i].name + " Дата создания: " + tracker.applications[i].date + "  Описание: " + tracker.applications[i].description);
        for (int j = 0; j < tracker.applications[i].quantityofcomments; j++) {
            if (tracker.applications[i].comments[j].equals("") == false)
                System.out.println("Комментарий " + (j + 1) + ": " + tracker.applications[i].comments[j]);
        }
    }
    /**
     * Отображение списка заявок по фильтру. Поиск происходит по содержанию подстроки в строке.
     * @return true если одстрока в строке содержится, false если не содержится
     */
    static boolean containssubstring(String origin, String sub) {
        boolean answer = false;
        char[] arrayorigin = origin.toCharArray();
        char[] arraysub = sub.toCharArray();
        if(origin.indexOf(sub) != -1) answer = true;
        else answer = false;
        return answer;
    }
}


