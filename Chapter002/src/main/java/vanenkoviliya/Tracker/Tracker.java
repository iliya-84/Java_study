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
    List<Application> applications = new ArrayList();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Добавление заявки.
     */
    void add() throws Exception{
        applications.add(new Application());
        System.out.println("*Ведите имя:");
        applications.get(applications.size()-1).name=reader.readLine();;
        System.out.println("*Ведите описание:");
        applications.get(applications.size()-1).description = reader.readLine();
        System.out.println("*Ведите комментарий:");
        String comment = reader.readLine();
        if (comment.equals("")==false)  applications.get(applications.size()-1).comments.add(comment);
    }

    /**
     * Редактирования заявки.
     */
    void edit() throws Exception{
        System.out.println("*Выберите номер заявки для редактирования:");
        try {
            int number = Integer.parseInt(reader.readLine()) - 1;
            applicationprint(number);

        System.out.println("*Для изменения имени нажмите 1 \n*Для изменения описания нажмите 2\n*Для добавления комментария нажмите 3");
        String change = reader.readLine();
        if (change.equals("1")) {
            System.out.println("*Введите имя:");
            applications.get(number).name = reader.readLine();
        }
        else if (change.equals("2")) {
            System.out.println("*Введите описание:");
            applications.get(number).description = reader.readLine();
        }
        else if (change.equals("3")) {
            System.out.println("*Введите комментарий");
                applications.get(number).comments.add(reader.readLine());
        }
        else System.out.println("*Неверный ввод");

        }
        catch (NumberFormatException e) {
            System.out.println("*Неверный ввод");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("*Заявка не существует");
        }
    }
    /**
     * Удаления заявки.
     */
    void delete() throws Exception{
        System.out.println("*Выберите номер заявки для удаления:");
        try {
            int number = Integer.parseInt(reader.readLine())-1;
            applications.remove(number);
        }
        catch (NumberFormatException e) {
            System.out.println("*Неверный ввод");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("*Заявка не существует");
        }
      }
    /**
     * Отображение списка всех заявок.
     */
    void getlist() {
        for(int i=0;i<applications.size();i++){
            applicationprint(i);
          }
        }

    /**
     * Вывод в консоль заявки по номеру.
     * @param i массив для сортировки
     */
    void applicationprint(int i) {
        System.out.println("№" + (i + 1) + " Имя:" + applications.get(i).name + " Дата создания: " + applications.get(i).date + "  Описание: " + applications.get(i).description);
        for (int j = 0; j < applications.get(i).comments.size(); j++) {
            if (applications.get(i).comments.get(j).equals("") == false) System.out.println("Комментарий " + (j + 1) + ": " + applications.get(i).comments.get(j));
        }
    }
}




