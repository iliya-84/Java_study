package vanenkoviliya.Tracker;

import java.util.Scanner;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 16.11.2016
 **/
public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);
    /** Вывод строки из консоли.
     * @param question вопрос пользователю.
     * @return ответ пользователя.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
      }
}


