package vanenkoviliya.Tracker;

import java.util.Scanner;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 16.11.2016
 **/
public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    /** Ввод строки из консоли.
     * @param question вопрос пользователю.
     * @return ответ пользователя в формате String.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
      }

    /** Ввод строки из консоли с учетом перечня допустимых ключей.
     * @param question вопрос пользователю.
     * @param range массив допустимых ключей.
      * @return ответ пользователя в формате int при совпадении ответа с допустимыми ключами. Кидает  исключение, если ответ не совпадает с допустимыми ключами.
     */
    public int ask(String question, int[] range)  {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
         for (int value : range) {
            if (value == key && key != 0) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
          throw new MenuOutException("*В меню нет такого пункта.");
        }
    }
}


