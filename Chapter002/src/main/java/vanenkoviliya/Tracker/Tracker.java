package vanenkoviliya.Tracker;

import java.util.Random;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class Tracker {
    Application[] applications = new Application[100];
    int quantity =0;
    Random random = new Random();
    /**
     * Добавление заявки. Заявке случайным образом присваиваится id. Также происходит проверка на совпадение с уже существующими id.
     */
    void add() throws Exception{
        applications[quantity] = new Application();
        int randomid=0;
        boolean repeatid = false;
        while(repeatid == false) {
          repeatid = true;
          randomid = random.nextInt(1000);
          for(int i=0;i<quantity;i++){
             if (randomid == applications[i].id) repeatid = false;
        }
    }
        applications[quantity].id = randomid;
        quantity++;
    }

    /**
     * Редактирования заявки.
     * @param id заявки
     * @param change изменяемое поле
     * @param value новое значение поля
     */
    void edit(int id, String change, String value) {
            if (change.equals("1")) {
                findById(id).name = value;
            } else if (change.equals("2")) {
                findById(id).description = value;
            } else if (change.equals("3")) {
                findById(id).addcomment(value);
            }
    }
    /**
     * Удаления заявки.
     * @param id id заявки
     */
    void delete(int id) {
        int number = -1;
        for (int i = 0; i < quantity; i++) {
            if (applications[i].getid() == id) {
                applications[i] = null;
                number = i;
            }
        }
        if (number > -1) {
            for (int j = number; j < quantity; j++) {
                Application temporary = new Application();
                temporary = applications[j];
                applications[j] = applications[j + 1];
                applications[j + 1] = temporary;
            }
            quantity--;
        }
        else throw new NullPointerException("id is null");
    }
    /**
     * Поиск заявки по id.
     * @param id заявки
     * @return заявка с заданным id
     */
        Application findById(int id) {
            for(int i = 0; i < quantity; i++) {
                 if (applications[i].getid() == id) return applications[i];
            }
            return null;
     }
    /**
     * Возвращает весь массив заявок.
     * @return массив заявок
     */
    Application[] getAll() {
         return applications;
     }
}




