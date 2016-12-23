package vanenkoviliya.Tracker;

import java.util.Random;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class Tracker {
    Application[] applications = new Application[100];
    int quantity =0; // Количество заявок в трекере.
    /**
     * Добавление заявки. Заявке случайным образом присваиваится id. Также происходит проверка на совпадение с уже существующими id.
     * @param newapplication заявка для добавления.
     */
    void add(Application newapplication){
        Random random = new Random();
        String randomId="0";
        boolean repeatId = false;
        applications[quantity]=newapplication;
        while(repeatId == false) {
          repeatId = true;
          randomId = Integer.toString(random.nextInt(1000));
          for(int i=0;i<quantity;i++){
             if (randomId == applications[i].id) repeatId = false;
        }
    }
        applications[quantity].id = randomId;
        quantity++;
    }
    /**
     * Редактирования заявки. Передает заявку, сформированную в меню в трекер. Присваивает ей комментарии старой заявки. Записывает новую заявку на место старой.
     * @param newApplication измененная заявка.
     */
    void edit(Application newApplication) {
        newApplication.comments=getdApplicationById(newApplication.id).comments;
        newApplication.quantityOfComments=getdApplicationById(newApplication.id).quantityOfComments;
        applications[getdById(newApplication.id)] = newApplication;
       }

    /**
     * Удаления заявки.
     * @param id id заявки.
     */
    void delete(String id) {
        int number = -1;
        for (int i = 0; i < quantity; i++) {
            if (applications[i].getId().equals(id)) {
                applications[i] = null;
                number = i;
            }
        }
        if (number > -1) {
            for (int j = number; j < quantity; j++) {
                Application temporary = applications[j];
                applications[j] = applications[j + 1];
                applications[j + 1] = temporary;
            }
            quantity--;
        }
        else throw new NullPointerException();
    }
    /**
     * Поиск заявки по id.
     * @param id заявки.
     * @return номер в массиве заявки с заданным id.
     */
       int getdById(String id) {
           for(int i = 0; i < quantity; i++) {
               if (applications[i].getId().equals(id)) return i;
           }
           return -1;
     }
    /**
     * Поиск заявки по id.
     * @param id заявки.
     * @return заявка с заданным id.
     */
    Application getdApplicationById(String id) {
        for(int i = 0; i < quantity; i++) {
            if (applications[i].getId().equals(id)) return applications[i];
        }
        return null;
    }

    /**
     * Возвращает весь массив заявок.
     * @return массив заявок
     */
    Application[] getAllApplications() {
        Application[] getApplication = new Application[quantity];
        for(int i =0; i<quantity;i++)
        getApplication[i]= applications[i];
        return getApplication;
     }
}



