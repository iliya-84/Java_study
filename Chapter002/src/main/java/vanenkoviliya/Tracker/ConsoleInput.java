package vanenkoviliya.Tracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 16.11.2016
 **/
public class ConsoleInput {
    StartUi startui = new StartUi();
    /**
     * Вывод меню для выбора действия.
     * @return результат выбора.
     */
      String input() throws Exception {
          String menu;
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
              menu = reader.readLine();
              return menu;

      }
}


