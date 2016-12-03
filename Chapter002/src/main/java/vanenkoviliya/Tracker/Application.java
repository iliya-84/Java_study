package vanenkoviliya.Tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author vanenkov_ia
 * @version 1
 * @since 07.11.2016
 **/
public class Application {
    int id;
    String name;
    String description;
    Date date = new Date();
    Comment[] comments = new Comment[10];
    int quantityofcomments = 0;
    /**
     * Метод возвращает id заявки.
     * @return id заявке
     */
     int getid() {
       return id;
    }
    /**
     * Метод присваивает id заявке.
     * @param id новый id заявки
     */
     void setid(int id) {
        this.id=id;
    }
    /**
     * Метод добавляет комментарий к заявке заявке.
     * @param text текст комментария
     */
    void addcomment(String text) {
        comments[quantityofcomments]= new Comment();
        comments[quantityofcomments].text = text;
        quantityofcomments++;
    }
    /**
     * Метод возвращает массив комментариев.
     * @return массив комментариев
     */
    Comment[] returncomments() {
        return comments;
    }
}


