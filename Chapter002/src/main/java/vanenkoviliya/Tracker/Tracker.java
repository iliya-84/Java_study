package vanenkoviliya.Tracker;

import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class Tracker {
    Application[] applications = new Application[100];
    int quantity =0;
    /**
     * Добавление заявки.
     */
    void add() throws Exception{
        applications[quantity] = new Application();
        quantity++;
    }

    /**
     * Редактирования заявки.
     * @param number номер заявки
     * @param change изменяемое поле
     * @param value новое значение поля
     */
    void edit(int number, String change, String value) {
        if (change.equals("1")) {
            applications[number].name = value;
        }
        else if (change.equals("2")) {
            applications[number].description = value;
        }
        else if (change.equals("3")) {
         applications[number].comments[applications[number].quantityofcomments] = value;
         applications[number].quantityofcomments++;
        }
    }
    /**
     * Удаления заявки.
     */
    void delete(int number) {
        applications[number]=null;
          for(int i = number; i < quantity - 1; i++) {
            Application temporary = new Application();
            temporary = applications[i];
            applications[i] = applications[i + 1];
            applications[i + 1] = temporary;
        }
        quantity--;
    }
}




